package com.lin.service;

import com.lin.constants.Status;
import com.lin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This file was created by Songlin Li on 2015/11/03.
 * It is used for different command executive
 */
public class CommandService {
    private static Logger log = Logger.getLogger(CommandService.class);
    private static CommandService _instance;
    private static FileService fileService = FileService.getInstance();

    /**
     * Singleton patter, private the constructor method
     */
    private CommandService() {
    }

    /**
     * @param commandTemplate
     */
    public static void generateCommandFile(String commandTemplate) {

        if (StringUtils.isEmpty(commandTemplate)) {
            log.warn("Command template file is empty, can't generate a command file");
            return;
        }

        byte[] newLine = "\r\n".getBytes();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String line;

        try {
            File commandFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileService.getFileNameWithoutExtension(commandTemplate) + ".bat");
            if (commandFile.exists() == false) {
                commandFile.createNewFile();
            }
            outputStream = new FileOutputStream(commandFile);
            inputStream = CommandService.class.getClassLoader().getResourceAsStream("templates/command/" + commandTemplate);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((line = bufferedReader.readLine()) != null) {
                line = parseTemplateVariables(line);
                outputStream.write(line.getBytes());
                outputStream.write(newLine);
                //log.debug(line);
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * We will parse variables such as ${abc} inside content, get their real value
     *
     * @param content the content with variables
     * @return content of plain text
     */
    private static String parseTemplateVariables(String content) {
        if (StringUtils.isEmpty(content) || content.indexOf("${") == -1) {
            return content;
        }
        Pattern pattern = Pattern.compile("\\$\\{([^\\}]+)\\}");
        Matcher matcher = pattern.matcher(content);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String matcherKey = matcher.group(1);
            String matchervalue = PropertiesService.getInstance().get(matcherKey);
            if (matchervalue != null) {
                matcher.appendReplacement(buffer, matchervalue);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * Execute specified command and return result
     *
     * @param command        the command to be executed
     * @param checkWords     a set of words to be checked and compared
     * @param isSuccessCheck if value is true, it means as long as command output contains words of
     *                       checkWords, we think command is executed successfully. If value is false, it means
     *                       as long as command output contains words of checkWords, we think command is executed
     *                       failed.
     * @return command execute result, either success of fail
     */
    public Result execute(String command, Set<String> checkWords, boolean isSuccessCheck) {
        Result result = new Result();
        result.setStatus(Status.SUCCESS);

        log.info("Start execute command:" + command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            while ((line = input.readLine()) != null) {
                log.debug(line);

                for (String checkWord : checkWords) {
                    if (line.contains(checkWord)) {
                        if (isSuccessCheck) {
                            result.setStatus(Status.SUCCESS);
                        } else {
                            result.setStatus(Status.FAILED);
                            //this line contain failed key words, put it as error message
                            result.setMessage(line);
                        }
                    }
                }
            }
        } catch (java.io.IOException e) {
            log.error("IOException " + e.getMessage());
        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
        }
        log.info("Finish execute command:" + command);

        return result;
    }

    /**
     * Singleton pattern to get instance of command service
     *
     * @return an instance of command service
     */
    public static CommandService getInstance() {
        if (_instance == null) {
            _instance = new CommandService();
        }
        return _instance;
    }

    public static void main(String[] args) {
        CommandService.getInstance().generateCommandFile("build.template");

    }

}
