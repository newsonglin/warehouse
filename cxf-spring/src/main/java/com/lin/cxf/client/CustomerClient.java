package com.lin.cxf.client;

import com.lin.cxf.vo.Customer;
import com.lin.cxf.vo.CustomerResponse;
import com.lin.cxf.vo.Headers;

public class CustomerClient {

    private CustomerClientService service;

    public CustomerClientService getService() {
        return service;
    }

    public void setService(CustomerClientService service) {
        this.service = service;
    }


    public CustomerResponse processCustomer(){
        Customer c= new Customer(12,"aaaaaabbbb");

        Headers headers= new Headers();
        headers.setHeader01("Let's go!");
        return service.processCustomer("<HotAutoPolicyDocgenDataSource xmlns:base=\"http://www.eisgroup.com/schema/eis/2015/base-core\">\n" +
                "\t<MetaData>\n" +
                "\t\t<autoGenerationIndex>true</autoGenerationIndex>\n" +
                "\t\t<entityRefNumber>M0000055</entityRefNumber>\n" +
                "\t\t<entityRefType>Policy</entityRefType>\n" +
                "\t\t<eventId>PROPOSE</eventId>\n" +
                "\t\t<packageId>hotAutoProposalPackage</packageId>\n" +
                "\t</MetaData>\n" +
                "\t<DocgenEventEntity>\n" +
                "\t\t<createdAt>2020-10-12T16:53:18.48+08:00</createdAt>\n" +
                "\t\t<docgenTicket>4674272854836224092</docgenTicket>\n" +
                "\t\t<entityId>1822118</entityId>\n" +
                "\t\t<entityRefNo>M0000055</entityRefNo>\n" +
                "\t\t<entityType>Policy</entityType>\n" +
                "\t\t<eventName>PROPOSE</eventName>\n" +
                "\t\t<productCd>PREC-AU</productCd>\n" +
                "\t\t<subsystem>Policy</subsystem>\n" +
                "\t\t<userLoginName>qa</userLoginName>\n" +
                "\t</DocgenEventEntity>\n" +
                "\t<IndividualCustomer>\n" +
                "\t\t<customerNumber>510062</customerNumber>\n" +
                "\t\t<taxExemptInd>false</taxExemptInd>\n" +
                "\t\t<EmailList>\n" +
                "\t\t\t<Email>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"PERS\">個人</contactTypeCd>\n" +
                "\t\t\t\t<emailId>starp@lulala.com.tw</emailId>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t</Email>\n" +
                "\t\t\t<Email>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"WORK\">工作</contactTypeCd>\n" +
                "\t\t\t\t<emailId>starw@lulala.com.tw</emailId>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t</Email>\n" +
                "\t\t</EmailList>\n" +
                "\t\t<AddressList>\n" +
                "\t\t\t<Address>\n" +
                "\t\t\t\t<addressLine1>中興街130巷25號1樓</addressLine1>\n" +
                "\t\t\t\t<addressLine2/>\n" +
                "\t\t\t\t<addressLine3/>\n" +
                "\t\t\t\t<city lookupCode=\"37\">永和區</city>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"MAILING\">地址</contactTypeCd>\n" +
                "\t\t\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t\t\t<postalCode>234</postalCode>\n" +
                "\t\t\t\t<stateProvCd lookupCode=\"NWT\">新北市</stateProvCd>\n" +
                "\t\t\t\t<communicationPreferences>POLICY_DOC</communicationPreferences>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t\t<attention/>\n" +
                "\t\t\t\t<addressValidatedInd>No</addressValidatedInd>\n" +
                "\t\t\t\t<temporary>false</temporary>\n" +
                "\t\t\t</Address>\n" +
                "\t\t</AddressList>\n" +
                "\t\t<PhoneList>\n" +
                "\t\t\t<Phone>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"FAX\">傳真</contactTypeCd>\n" +
                "\t\t\t\t<extension/>\n" +
                "\t\t\t\t<phoneNumber>0221815088</phoneNumber>\n" +
                "\t\t\t\t<temporary>false</temporary>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t\t<doNotSolicitInd>false</doNotSolicitInd>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t</Phone>\n" +
                "\t\t\t<Phone>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"HOME\">住家</contactTypeCd>\n" +
                "\t\t\t\t<extension/>\n" +
                "\t\t\t\t<phoneNumber>0222198871</phoneNumber>\n" +
                "\t\t\t\t<temporary>false</temporary>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t\t<doNotSolicitInd>false</doNotSolicitInd>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t</Phone>\n" +
                "\t\t\t<Phone>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"MOB\">行動電話</contactTypeCd>\n" +
                "\t\t\t\t<extension/>\n" +
                "\t\t\t\t<phoneNumber>0900111223</phoneNumber>\n" +
                "\t\t\t\t<temporary>false</temporary>\n" +
                "\t\t\t\t<consentToTextStatus>NOT_REQUESTED</consentToTextStatus>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t\t<doNotSolicitInd>false</doNotSolicitInd>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t</Phone>\n" +
                "\t\t\t<Phone>\n" +
                "\t\t\t\t<contactTypeCd lookupCode=\"WORK\">工作</contactTypeCd>\n" +
                "\t\t\t\t<extension>1635</extension>\n" +
                "\t\t\t\t<phoneNumber>21815000</phoneNumber>\n" +
                "\t\t\t\t<temporary>false</temporary>\n" +
                "\t\t\t\t<comment/>\n" +
                "\t\t\t\t<doNotSolicitInd>false</doNotSolicitInd>\n" +
                "\t\t\t\t<consentStatus>NOT_REQUESTED</consentStatus>\n" +
                "\t\t\t</Phone>\n" +
                "\t\t</PhoneList>\n" +
                "\t\t<ChatList/>\n" +
                "\t\t<SocialNetList/>\n" +
                "\t\t<WebAddressList/>\n" +
                "\t\t<CustomerGroupInfoList/>\n" +
                "\t\t<CustomerAdditionalNameList/>\n" +
                "\t\t<salutationCd lookupCode=\"3\">先生</salutationCd>\n" +
                "\t\t<firstName>星星</firstName>\n" +
                "\t\t<middleName/>\n" +
                "\t\t<lastName>周</lastName>\n" +
                "\t\t<taxId>J189020761</taxId>\n" +
                "\t\t<dateOfBirth>1983-05-18</dateOfBirth>\n" +
                "\t\t<genderCd lookupCode=\"male\">男</genderCd>\n" +
                "\t\t<citizenshipCd lookupCode=\"TW\">中華民國</citizenshipCd>\n" +
                "\t\t<deceased>false</deceased>\n" +
                "\t\t<deathNotificationReceived>false</deathNotificationReceived>\n" +
                "\t</IndividualCustomer>\n" +
                "\t<Agency>\n" +
                "\t\t<channelCd lookupCode=\"corporate\">公司內部</channelCd>\n" +
                "\t\t<locationTypeCd lookupCode=\"corporate_expressoffice\">corporate_expressoffice</locationTypeCd>\n" +
                "\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t<marketingChannel>10</marketingChannel>\n" +
                "\t\t<code>AHT06001</code>\n" +
                "\t\t<name>台北分公司-營業一部</name>\n" +
                "\t\t<additionalName>台北營一</additionalName>\n" +
                "\t\t<effective>2020-01-01</effective>\n" +
                "\t\t<expiration>2999-12-31</expiration>\n" +
                "\t\t<taxIdentity>89388700</taxIdentity>\n" +
                "\t\t<isPrimary>false</isPrimary>\n" +
                "\t\t<Address>\n" +
                "\t\t\t<addressLine1>忠孝西路一段39號7樓</addressLine1>\n" +
                "\t\t\t<city>1</city>\n" +
                "\t\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t\t<postalCode>10041</postalCode>\n" +
                "\t\t\t<stateProvCd lookupCode=\"TPE\">臺北市</stateProvCd>\n" +
                "\t\t</Address>\n" +
                "\t\t<ContactList/>\n" +
                "\t</Agency>\n" +
                "\t<autoPolicyPayload entitySubtype=\"policy\" productCode=\"PREC-AU\" productVersion=\"1.0\" rootEntityType=\"policy\">\n" +
                "\t\t<Policy cid=\"Policy1\" parentRefId=\"\" refId=\"uB3YSGP4_08CeYtyfxtBVg\" reference=\"Policy\" state=\"NoChange\">\n" +
                "\t\t\t<aggregatedProposalInd>false</aggregatedProposalInd>\n" +
                "\t\t\t<compInsureAgeCoeff>0.92</compInsureAgeCoeff>\n" +
                "\t\t\t<compInsureCertNo>CM0000055</compInsureCertNo>\n" +
                "\t\t\t<compInsureQuerySerial>201012B9742573</compInsureQuerySerial>\n" +
                "\t\t\t<contractTermTypeCd lookupCode=\"01\">1 Year</contractTermTypeCd>\n" +
                "\t\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t\t<coverageTypeCd lookupCode=\"single\">單一保額</coverageTypeCd>\n" +
                "\t\t\t<cplOrVltFactorsGotOrNot>true</cplOrVltFactorsGotOrNot>\n" +
                "\t\t\t<creationDate>2020-10-12T16:09:49</creationDate>\n" +
                "\t\t\t<currencyCd lookupCode=\"TWD\">TWD</currencyCd>\n" +
                "\t\t\t<currentTermGrade>4</currentTermGrade>\n" +
                "\t\t\t<customerNumber>510062</customerNumber>\n" +
                "\t\t\t<drunkDriveIncAmount>0.00</drunkDriveIncAmount>\n" +
                "\t\t\t<drunkDriveIncAmountPerTime>0.00</drunkDriveIncAmountPerTime>\n" +
                "\t\t\t<drunkDrivingTimes>0</drunkDrivingTimes>\n" +
                "\t\t\t<effective>2020-10-21T00:00:00</effective>\n" +
                "\t\t\t<expiration>2021-10-21T00:00:00</expiration>\n" +
                "\t\t\t<facultativeReinsuranceInd>false</facultativeReinsuranceInd>\n" +
                "\t\t\t<hoanChanneInd>false</hoanChanneInd>\n" +
                "\t\t\t<imported lookupCode=\"NEW\">EIS</imported>\n" +
                "\t\t\t<inspectionInd>false</inspectionInd>\n" +
                "\t\t\t<issueDurationDays>0</issueDurationDays>\n" +
                "\t\t\t<licenseNumber>E06F212847</licenseNumber>\n" +
                "\t\t\t<openTender>false</openTender>\n" +
                "\t\t\t<policyNumber>M0000055</policyNumber>\n" +
                "\t\t\t<policyStatusCd>proposed</policyStatusCd>\n" +
                "\t\t\t<producerCd>AHT06001</producerCd>\n" +
                "\t\t\t<producerMarketChannelCd>10</producerMarketChannelCd>\n" +
                "\t\t\t<rateEffectiveDate>2020-10-21T00:00:00</rateEffectiveDate>\n" +
                "\t\t\t<rateEffectiveDateOverridenInd>false</rateEffectiveDateOverridenInd>\n" +
                "\t\t\t<receiptDurationDays>0</receiptDurationDays>\n" +
                "\t\t\t<region>60 台北分公司</region>\n" +
                "\t\t\t<renewalCycle>0</renewalCycle>\n" +
                "\t\t\t<revisionNo>0</revisionNo>\n" +
                "\t\t\t<riskStateCd lookupCode=\"NWT\">新北市</riskStateCd>\n" +
                "\t\t\t<rootEntityTypeAsString>policy</rootEntityTypeAsString>\n" +
                "\t\t\t<salesSource>1</salesSource>\n" +
                "\t\t\t<subProducerCd>2020000081</subProducerCd>\n" +
                "\t\t\t<timeZone>Asia/Taipei</timeZone>\n" +
                "\t\t\t<transactionDate>2020-10-12T00:00:00</transactionDate>\n" +
                "\t\t\t<transactionEffectiveDate>2020-10-21T00:00:00</transactionEffectiveDate>\n" +
                "\t\t\t<txType>quote</txType>\n" +
                "\t\t\t<txTypeAsString>quote</txTypeAsString>\n" +
                "\t\t\t<typeOfPolicyCd lookupCode=\"01\">強制險</typeOfPolicyCd>\n" +
                "\t\t\t<underwritingUserName>Auto UW</underwritingUserName>\n" +
                "\t\t\t<vehicleCategoryCd lookupCode=\"03\">03 自用小客車</vehicleCategoryCd>\n" +
                "\t\t\t<vehicleTypeCd lookupCode=\"C\">汽車</vehicleTypeCd>\n" +
                "\t\t\t<PreconfigPersonInfo cid=\"PreconfigPersonInfo1\" parentRefId=\"Policy1\" refId=\"tWePcm87iGnYBT6fz9RNPg\" reference=\"PreconfigPersonInfo\" state=\"NoChange\">\n" +
                "\t\t\t\t<IDType>1</IDType>\n" +
                "\t\t\t\t<dateOfBirth>1983-12-20T00:00:00</dateOfBirth>\n" +
                "\t\t\t\t<displayValue>月亮 金 金</displayValue>\n" +
                "\t\t\t\t<firstName>月亮</firstName>\n" +
                "\t\t\t\t<gender lookupCode=\"female\">女</gender>\n" +
                "\t\t\t\t<lastName>金</lastName>\n" +
                "\t\t\t\t<legalIdentification>A246123507</legalIdentification>\n" +
                "\t\t\t\t<maritalStatusCd lookupCode=\"M\">已婚</maritalStatusCd>\n" +
                "\t\t\t\t<middleName>金</middleName>\n" +
                "\t\t\t\t<occupationCategoryCd>0001</occupationCategoryCd>\n" +
                "\t\t\t\t<occupationCd>00</occupationCd>\n" +
                "\t\t\t\t<occupationWorkContentCd>00010010</occupationWorkContentCd>\n" +
                "\t\t\t\t<rateAge>36</rateAge>\n" +
                "\t\t\t\t<relationshipToPolicyHolder>02</relationshipToPolicyHolder>\n" +
                "\t\t\t\t<PreconfigPersonEmailContact cid=\"PreconfigPersonEmailContact1\" parentRefId=\"PreconfigPersonInfo1\" refId=\"jxAH40e8xOAgPDK8WztECA\" reference=\"PreconfigPersonEmailContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<email>moonp@lulala.com.tw</email>\n" +
                "\t\t\t\t\t<emailTypeCd>PERS</emailTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonEmailContact>\n" +
                "\t\t\t\t<PreconfigPersonEmailContact cid=\"PreconfigPersonEmailContact2\" parentRefId=\"PreconfigPersonInfo1\" refId=\"v0aGGJv7iCoSofRHqMpPcQ\" reference=\"PreconfigPersonEmailContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<email>moonw@lulala.com.tw</email>\n" +
                "\t\t\t\t\t<emailTypeCd>WORK</emailTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonEmailContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact1\" parentRefId=\"PreconfigPersonInfo1\" refId=\"pSVe933KBSinftnkV7ZFUQ\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(022) 901-8880</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0229018880</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>FAX</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact2\" parentRefId=\"PreconfigPersonInfo1\" refId=\"mad_lA50P3zpn9Q09ClIHg\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(022) 901-8881</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0229018881</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>HOME</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact3\" parentRefId=\"PreconfigPersonInfo1\" refId=\"t1E1dyPJqfOqHvoBGW5DeA\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(090) 001-8882</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0900018882</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>MOB</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact4\" parentRefId=\"PreconfigPersonInfo1\" refId=\"kND1-6NAVWmfoO6buK5ElA\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(022) 901-8883</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0229018883</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>WORK</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonAddressContact cid=\"PreconfigPersonAddressContact1\" parentRefId=\"PreconfigPersonInfo1\" refId=\"pTiTQcRxvC5SQ_r9cdtCHA\" reference=\"PreconfigPersonAddressContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<addressLine1>中華郵政689號信箱</addressLine1>\n" +
                "\t\t\t\t\t<addressLine2>(中興街131巷)</addressLine2>\n" +
                "\t\t\t\t\t<addressType>MAILING</addressType>\n" +
                "\t\t\t\t\t<city lookupCode=\"37\">永和區</city>\n" +
                "\t\t\t\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t\t\t\t<displayValue>中華郵政689號信箱, 37, NWT, 234, TW, MAILING </displayValue>\n" +
                "\t\t\t\t\t<postalCode>234</postalCode>\n" +
                "\t\t\t\t\t<stateProvCd lookupCode=\"NWT\">新北市</stateProvCd>\n" +
                "\t\t\t\t</PreconfigPersonAddressContact>\n" +
                "\t\t\t</PreconfigPersonInfo>\n" +
                "\t\t\t<PreconfigPersonInfo cid=\"PreconfigPersonInfo2\" parentRefId=\"Policy1\" refId=\"sxNbc9PKQCZdLZH13fJKhQ\" reference=\"PreconfigPersonInfo\" state=\"NoChange\">\n" +
                "\t\t\t\t<dateOfBirth>1983-05-18T00:00:00</dateOfBirth>\n" +
                "\t\t\t\t<displayValue>星星 周</displayValue>\n" +
                "\t\t\t\t<firstName>星星</firstName>\n" +
                "\t\t\t\t<gender lookupCode=\"male\">男</gender>\n" +
                "\t\t\t\t<lastName>周</lastName>\n" +
                "\t\t\t\t<legalIdentification>J189020761</legalIdentification>\n" +
                "\t\t\t\t<partyIdentification>510062</partyIdentification>\n" +
                "\t\t\t\t<titleCd>3</titleCd>\n" +
                "\t\t\t\t<PreconfigPersonEmailContact cid=\"PreconfigPersonEmailContact3\" parentRefId=\"PreconfigPersonInfo2\" refId=\"o0w7IjYDJTTYdgqCdMRM4Q\" reference=\"PreconfigPersonEmailContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<email>starp@lulala.com.tw</email>\n" +
                "\t\t\t\t\t<emailTypeCd>PERS</emailTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonEmailContact>\n" +
                "\t\t\t\t<PreconfigPersonEmailContact cid=\"PreconfigPersonEmailContact4\" parentRefId=\"PreconfigPersonInfo2\" refId=\"m0R385XMg6m6-6KnCRxC1Q\" reference=\"PreconfigPersonEmailContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<email>starw@lulala.com.tw</email>\n" +
                "\t\t\t\t\t<emailTypeCd>WORK</emailTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonEmailContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact5\" parentRefId=\"PreconfigPersonInfo2\" refId=\"m9ha5nu9eUxakOjRYb5Gog\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(022) 181-5088</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0221815088</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>FAX</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact6\" parentRefId=\"PreconfigPersonInfo2\" refId=\"r_1hDdfGLy0HFOVJ8XtOzg\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(022) 219-8871</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0222198871</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>HOME</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact7\" parentRefId=\"PreconfigPersonInfo2\" refId=\"gTHGyx4dSUnAlgtYRMxB5A\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>(090) 011-1223</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>0900111223</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>MOB</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonPhoneContact cid=\"PreconfigPersonPhoneContact8\" parentRefId=\"PreconfigPersonInfo2\" refId=\"sV-P81Uz5f3ba22WuMFPfA\" reference=\"PreconfigPersonPhoneContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<phoneDisplayValue>21815000</phoneDisplayValue>\n" +
                "\t\t\t\t\t<phoneNumber>21815000</phoneNumber>\n" +
                "\t\t\t\t\t<phoneTypeCd>WORK</phoneTypeCd>\n" +
                "\t\t\t\t</PreconfigPersonPhoneContact>\n" +
                "\t\t\t\t<PreconfigPersonAddressContact cid=\"PreconfigPersonAddressContact2\" parentRefId=\"PreconfigPersonInfo2\" refId=\"gUyYEk7_q5EdD3S64C9HgQ\" reference=\"PreconfigPersonAddressContact\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<addressLine1>中興街130巷25號1樓</addressLine1>\n" +
                "\t\t\t\t\t<addressType>MAILING</addressType>\n" +
                "\t\t\t\t\t<city lookupCode=\"37\">永和區</city>\n" +
                "\t\t\t\t\t<countryCd lookupCode=\"TW\">中華民國</countryCd>\n" +
                "\t\t\t\t\t<displayValue>中興街130巷25號1樓, 37, NWT, 234, TW, MAILING </displayValue>\n" +
                "\t\t\t\t\t<postalCode>234</postalCode>\n" +
                "\t\t\t\t\t<stateProvCd lookupCode=\"NWT\">新北市</stateProvCd>\n" +
                "\t\t\t\t</PreconfigPersonAddressContact>\n" +
                "\t\t\t</PreconfigPersonInfo>\n" +
                "\t\t\t<PreconfigInsured cid=\"PreconfigInsured1\" parentRefId=\"Policy1\" refId=\"ol_UnbNEKYPSwXxnAf9Hig\" reference=\"PreconfigInsured\" state=\"NoChange\">\n" +
                "\t\t\t\t<insuredIsPerson>true</insuredIsPerson>\n" +
                "\t\t\t\t<insuredName>月亮 金 金</insuredName>\n" +
                "\t\t\t\t<mainInsured>true</mainInsured>\n" +
                "\t\t\t\t<partySelected>party selected</partySelected>\n" +
                "\t\t\t\t<partySelection>party selected</partySelection>\n" +
                "\t\t\t\t<primaryInsured>true</primaryInsured>\n" +
                "\t\t\t\t<PreconfigPolicyPriorCarrier cid=\"PreconfigPolicyPriorCarrier1\" parentRefId=\"PreconfigInsured1\" refId=\"hXVa-8rOi9I7QLQqsZREMg\" reference=\"PreconfigPolicyPriorCarrier\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<carrierCd lookupCode=\"05\">富邦產物保險股份有限公司</carrierCd>\n" +
                "\t\t\t\t\t<carrierPolicyExpirationDate>2020-10-20T00:00:00</carrierPolicyExpirationDate>\n" +
                "\t\t\t\t\t<carrierPolicyNumber>03T0090876</carrierPolicyNumber>\n" +
                "\t\t\t\t\t<carrierPolicyPremium>1096.00</carrierPolicyPremium>\n" +
                "\t\t\t\t</PreconfigPolicyPriorCarrier>\n" +
                "\t\t\t\t<PreconfigInsuredPersonInfoProxy cid=\"PreconfigInsuredPersonInfoProxy1\" parentRefId=\"PreconfigInsured1\" refId=\"tMAKOFf-k3SFrn5gLTtOeA\" reference=\"PreconfigInsuredPersonInfoProxy\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonEmailContactProxy cid=\"PreconfigInsuredPersonEmailContactProxy1\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"guY8jiRMnJBbE0A7PXxAeA\" reference=\"PreconfigInsuredPersonEmailContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonEmailContactProxy cid=\"PreconfigInsuredPersonEmailContactProxy2\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"qf3K4Nrj_de5S3FnBS9LqQ\" reference=\"PreconfigInsuredPersonEmailContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonAddressContactProxy cid=\"PreconfigInsuredPersonAddressContactProxy1\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"sETocuytS7m_UnxW_CpNjw\" reference=\"PreconfigInsuredPersonAddressContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonPhoneContactProxy cid=\"PreconfigInsuredPersonPhoneContactProxy1\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"ivp0VZzb6zgPJNQOcHZLXg\" reference=\"PreconfigInsuredPersonPhoneContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonPhoneContactProxy cid=\"PreconfigInsuredPersonPhoneContactProxy2\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"rm0RSa-gXACWja2aXShNRw\" reference=\"PreconfigInsuredPersonPhoneContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonPhoneContactProxy cid=\"PreconfigInsuredPersonPhoneContactProxy3\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"jO2r5_DPsPG6WpwFPXlHJw\" reference=\"PreconfigInsuredPersonPhoneContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t\t<PreconfigInsuredPersonPhoneContactProxy cid=\"PreconfigInsuredPersonPhoneContactProxy4\" parentRefId=\"PreconfigInsuredPersonInfoProxy1\" refId=\"uwMJo_PlYcaS4JGfTYtJEQ\" reference=\"PreconfigInsuredPersonPhoneContactProxy\" state=\"NoChange\"/>\n" +
                "\t\t\t\t</PreconfigInsuredPersonInfoProxy>\n" +
                "\t\t\t\t<PreconfigCreditScoreInfo cid=\"PreconfigCreditScoreInfo1\" parentRefId=\"PreconfigInsured1\" refId=\"kwZLbv8wZ9eb_VQaMW1DWw\" reference=\"PreconfigCreditScoreInfo\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<creditScoreTypeCd>Good</creditScoreTypeCd>\n" +
                "\t\t\t\t</PreconfigCreditScoreInfo>\n" +
                "\t\t\t</PreconfigInsured>\n" +
                "\t\t\t<PreconfigVehicle cid=\"PreconfigVehicle1\" parentRefId=\"Policy1\" refId=\"qUA2u1C8db33gJNK6p5CPA\" reference=\"PreconfigVehicle\" state=\"NoChange\">\n" +
                "\t\t\t\t<additionalEquipInd>false</additionalEquipInd>\n" +
                "\t\t\t\t<additionalFacilityInd>false</additionalFacilityInd>\n" +
                "\t\t\t\t<adjustmentToMarketValue>25</adjustmentToMarketValue>\n" +
                "\t\t\t\t<adjustmentToMarketValueDisplay>100%</adjustmentToMarketValueDisplay>\n" +
                "\t\t\t\t<coverageTypeCd lookupCode=\"single\">單一保額</coverageTypeCd>\n" +
                "\t\t\t\t<displacement>2000.00</displacement>\n" +
                "\t\t\t\t<engineSerialNumber>9877345712</engineSerialNumber>\n" +
                "\t\t\t\t<highValueLuxuryInd>false</highValueLuxuryInd>\n" +
                "\t\t\t\t<importInd>false</importInd>\n" +
                "\t\t\t\t<manufacturer>馬自達(國產)</manufacturer>\n" +
                "\t\t\t\t<marketValue>699000.00</marketValue>\n" +
                "\t\t\t\t<modelYear>202008</modelYear>\n" +
                "\t\t\t\t<numberOfPassenger>5</numberOfPassenger>\n" +
                "\t\t\t\t<physicalDamageCode>21</physicalDamageCode>\n" +
                "\t\t\t\t<registrationDate>202009</registrationDate>\n" +
                "\t\t\t\t<series>Mazda  3  2.0  4D  尊貴型  5人座</series>\n" +
                "\t\t\t\t<theftCode>7</theftCode>\n" +
                "\t\t\t\t<umCoverageTypeCd>single</umCoverageTypeCd>\n" +
                "\t\t\t\t<vehIdentificationNo>11101200</vehIdentificationNo>\n" +
                "\t\t\t\t<vehTypeCd lookupCode=\"00\">00非特殊車輛種類</vehTypeCd>\n" +
                "\t\t\t\t<vehicleCategoryFilterInd>true</vehicleCategoryFilterInd>\n" +
                "\t\t\t\t<vehicleUsageCd>P</vehicleUsageCd>\n" +
                "\t\t\t\t<TwentyOneCoverageComponent cid=\"TwentyOneCoverageComponent1\" parentRefId=\"PreconfigVehicle1\" refId=\"sQGuG6gwCBi2ncmXuoRBfg\" reference=\"TwentyOneCoverageComponent\" state=\"NoChange\">\n" +
                "\t\t\t\t\t<additionalLimitAmount>2000000.00</additionalLimitAmount>\n" +
                "\t\t\t\t\t<combinedLimitAmount>200000/2000000/2000000</combinedLimitAmount>\n" +
                "\t\t\t\t\t<coverageCd>21</coverageCd>\n" +
                "\t\t\t\t\t<effectiveDate>2020-10-21T00:00:00</effectiveDate>\n" +
                "\t\t\t\t\t<limitAmount>200000.00</limitAmount>\n" +
                "\t\t\t\t\t<tariffEffectiveDate>2019-11-01T00:00:00</tariffEffectiveDate>\n" +
                "\t\t\t\t</TwentyOneCoverageComponent>\n" +
                "\t\t\t</PreconfigVehicle>\n" +
                "\t\t\t<PreconfigVehiclePackageManager cid=\"PreconfigVehiclePackageManager1\" parentRefId=\"Policy1\" refId=\"tCOwBllU1E-r3EqOX3BLMA\" reference=\"PreconfigVehiclePackageManager\" state=\"NoChange\">\n" +
                "\t\t\t\t<packageCd>Compulsory</packageCd>\n" +
                "\t\t\t</PreconfigVehiclePackageManager>\n" +
                "\t\t</Policy>\n" +
                "\t\t<CoverageList>\n" +
                "\t\t\t<Coverage>\n" +
                "\t\t\t\t<coverageCd>21</coverageCd>\n" +
                "\t\t\t\t<coverageName>21-強制險</coverageName>\n" +
                "\t\t\t\t<limitAmount>200000.00</limitAmount>\n" +
                "\t\t\t\t<limitAmountLabel>每一個人傷害醫療/每一個人失能/每一個人死亡</limitAmountLabel>\n" +
                "\t\t\t\t<additionalLimitAmount>2000000.00</additionalLimitAmount>\n" +
                "\t\t\t\t<combinedLimitAmount>200000/2000000/2000000</combinedLimitAmount>\n" +
                "\t\t\t\t<combinedLimitAmountLabel>每一個人傷害醫療/每一個人失能/每一個人死亡</combinedLimitAmountLabel>\n" +
                "\t\t\t\t<seqNo>1</seqNo>\n" +
                "\t\t\t\t<extendLimitAmount>2000000.00</extendLimitAmount>\n" +
                "\t\t\t\t<Premiums>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>GWT</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>GWT</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>GROSS_PREMIUM</premiumType>\n" +
                "\t\t\t\t\t\t\t<annualAmt>1318.0000000000000000</annualAmt>\n" +
                "\t\t\t\t\t\t\t<periodAmt>1318.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>1318.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<changeAmt>1318.0000000000000000</changeAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>CMS</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>CMS</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>COMMISSIONS</premiumType>\n" +
                "\t\t\t\t\t\t\t<factor>0.0000000000000000</factor>\n" +
                "\t\t\t\t\t\t\t<periodAmt>0.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>0.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<changeAmt>0.0000000000000000</changeAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>RAW</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>RAW</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>BASE_PREMIUM</premiumType>\n" +
                "\t\t\t\t\t\t\t<factor>1.0000000000000000</factor>\n" +
                "\t\t\t\t\t\t\t<annualAmt>1318.0000000000000000</annualAmt>\n" +
                "\t\t\t\t\t\t\t<periodAmt>1318.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>1318.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<changeAmt>1318.0000000000000000</changeAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>CMR</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>CMR</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>COMMISSIONS</premiumType>\n" +
                "\t\t\t\t\t\t\t<factor>0.0000000000000000</factor>\n" +
                "\t\t\t\t\t\t\t<periodAmt>0.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>0.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<changeAmt>0.0000000000000000</changeAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>NWT</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>NWT</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>NET_PREMIUM</premiumType>\n" +
                "\t\t\t\t\t\t\t<factor>1.0000000000000000</factor>\n" +
                "\t\t\t\t\t\t\t<annualAmt>1318.0000000000000000</annualAmt>\n" +
                "\t\t\t\t\t\t\t<periodAmt>1318.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>1318.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<changeAmt>1318.0000000000000000</changeAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t\t<entry>\n" +
                "\t\t\t\t\t\t<key>NWT/R</key>\n" +
                "\t\t\t\t\t\t<value>\n" +
                "\t\t\t\t\t\t\t<premiumCd>NWT/R</premiumCd>\n" +
                "\t\t\t\t\t\t\t<premiumType>NET_PREMIUM</premiumType>\n" +
                "\t\t\t\t\t\t\t<annualAmt>1318.0000000000000000</annualAmt>\n" +
                "\t\t\t\t\t\t\t<periodAmt>1318.0000000000000000</periodAmt>\n" +
                "\t\t\t\t\t\t\t<actualAmt>1318.0000000000000000</actualAmt>\n" +
                "\t\t\t\t\t\t\t<createdOn>2020-10-12T16:09:49.453+08:00</createdOn>\n" +
                "\t\t\t\t\t\t</value>\n" +
                "\t\t\t\t\t</entry>\n" +
                "\t\t\t\t</Premiums>\n" +
                "\t\t\t</Coverage>\n" +
                "\t\t</CoverageList>\n" +
                "\t\t<policyVersion>1</policyVersion>\n" +
                "\t\t<dataSourceGeneratedDate>2020-10-12T00:00:00+08:00</dataSourceGeneratedDate>\n" +
                "\t\t<packageName>強制險方案</packageName>\n" +
                "\t\t<policyPremiumAmount>1318.0000000000000000</policyPremiumAmount>\n" +
                "\t\t<policyApRpAmount>1318.0000000000000000</policyApRpAmount>\n" +
                "\t\t<subProducerName>吳 哲銘</subProducerName>\n" +
                "\t\t<preRevisionNo>0</preRevisionNo>\n" +
                "\t</autoPolicyPayload>\n" +
                "</HotAutoPolicyDocgenDataSource>\n", headers);
    }
}
