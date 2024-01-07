package mitei.mitei.create.report.balance.politician.dto.publish; // NOPMD

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * AllBookDto単体テスト
 */
class AllBookDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXmlLeast() throws Exception { // NOPMD

        AllBookDto allBookDto = new AllBookDto();

        // ヘッダ
        AllBookHeaderDto allBookHeaderDto = new AllBookHeaderDto();
        allBookHeaderDto.setVersion("20191220");
        allBookHeaderDto.setAppName("収支報告書作成ソフト〔収支報告書作成ソフト〕");
        allBookHeaderDto.setFileFormatNo("1");
        allBookHeaderDto.setFlgKokuji("0");
        allBookHeaderDto.setChouboAppVer("20150701");

        allBookDto.setAllBookHeaderDto(allBookHeaderDto);

        // 入力有無テキスト
        AllBookUmuInputDataDto allBookUmuInputDataDto = new AllBookUmuInputDataDto();
        allBookUmuInputDataDto.setInputBitText("110000000000000000001000000000000010000000000000100");

        allBookDto.setAllBookUmuInputDataDto(allBookUmuInputDataDto);

        // sheet0701表紙
        AllSheet0701CoverAndOrganizationDetailsDto allSheet0701CoverAndOrganizationDetailsDto = new AllSheet0701CoverAndOrganizationDetailsDto();
        Sheet070100CoverAndOrganizationDetailsDto sheet070100 = new Sheet070100CoverAndOrganizationDetailsDto();
        sheet070100.setHoukokuNen(2021);
        sheet070100.setDateKaisai("");
        sheet070100.setDantaiName("サンプル政治団体");
        sheet070100.setDantaiNameKana("さんぷるせいじだんたい");
        sheet070100.setJimushoJusho("東京都千代田区");
        sheet070100.setJimushoJushoTatemono("");
        sheet070100.setDaihyoushaNameLast("代表者");
        sheet070100.setDaihyoushaNameFirst("次郎");
        sheet070100.setKaikeiSekinnshaNameLast("会計責任者");
        sheet070100.setKaikeiSekinnshaNameFirst("花子");
        sheet070100.setJimuTantousha1NameLast("事務担当者");
        sheet070100.setJimuTantousha1NameFirst("三郎");
        sheet070100.setJimuTantousha1Tel("111-2222-3333");
        sheet070100.setJimuTantousha2NameLast("");
        sheet070100.setJimuTantousha2NameFirst("");
        sheet070100.setJimuTantousha2Tel("");
        sheet070100.setJimuTantousha3NameLast("");
        sheet070100.setJimuTantousha3NameFirst("");
        sheet070100.setJimuTantousha3Tel("");
        sheet070100.setDantaiKbn("05");
        sheet070100.setKatsudouKuikiKbn(2);
        sheet070100.setUmuShikinKanrenDantai(0);
        sheet070100.setKoushokuName("");
        sheet070100.setKoushokuGenKouho("");
        sheet070100.setShikinDaihyouName1("");
        sheet070100.setShikinDaihyouName2("");
        sheet070100.setKanriDantaiPeriodStart("");
        sheet070100.setKanriDantaiPeriodEnd("");
        sheet070100.setKanriDantaiPeriodRest("");
        sheet070100.setKokkaiGiinDantaiKbn(0);
        sheet070100.setKokkaiGiin1NameLast("");
        sheet070100.setKokkaiGiin1NameFirst("");
        sheet070100.setKokkaiGiin1ShuuSan("");
        sheet070100.setKokkaiGiin1GenKouho("");
        sheet070100.setGiinDantantaiTokureiPeriodStart("");
        sheet070100.setGiinDantantaiTokureiPeriodEnd("");
        sheet070100.setGiinDantantaiTokureiPeriodRest("");
        sheet070100.setKokkaiGiin2NameLast("");
        sheet070100.setKokkaiGiin2NameFirst("");
        sheet070100.setKokkaiGiin2ShuuSan("");
        sheet070100.setKokkaiGiin2GenKouho("");
        sheet070100.setKokkaiGiin3NameLast("");
        sheet070100.setKokkaiGiin3NameFirst("");
        sheet070100.setKokkaiGiin3ShuuSan("");
        sheet070100.setKokkaiGiin3GenKouho("");

        allSheet0701CoverAndOrganizationDetailsDto.setSheet070100CoverAndOrganizationDetailsDto(sheet070100);

        allBookDto.setAllSheet0701CoverAndOrganizationDetailsDto(allSheet0701CoverAndOrganizationDetailsDto);

        /**
         * シート2
         */
        AllSheet0702SummaryTableIncomeDto allSheet0702SummaryTableIncomeDto = new AllSheet0702SummaryTableIncomeDto();

        Sheet070200SummaryTableIncomeExpenditureDto sheet02 = new Sheet070200SummaryTableIncomeExpenditureDto();
        sheet02.setShunyuGokei(0L);
        sheet02.setZennenKurikoshi(0L);
        sheet02.setHonnenShunyu(0L);
        sheet02.setShishutsuGoukei(0L);
        sheet02.setYokunenKurikoshi(0L);
        sheet02.setKojiFutanGoukei("");
        sheet02.setKojiFutanSuu("");
        sheet02.setKojinKifuGoukei(0L);
        sheet02.setKojinKifuBikou("");
        sheet02.setTokuteiKifuGoukei("");
        sheet02.setTokuteiKifuBikou("");
        sheet02.setHoujinKifuGoukei(0L);
        sheet02.setHoujinKifuBiko("");
        sheet02.setSeijiDantaiKifuGoukei(0L);
        sheet02.setSeijiDantaiKifuBikou("");
        sheet02.setKifuShoukeiGoukei(0L);
        sheet02.setKifuShoukeiBikou("");
        sheet02.setAssenGoukei(0L);
        sheet02.setAssenBikou("");
        sheet02.setTokumeiKifuGoukei(0L);
        sheet02.setTokumeiKifuBikou("");
        sheet02.setKifuSoGoukei(0L);
        sheet02.setKifuSoGoukeiBikou("");

        allSheet0702SummaryTableIncomeDto.setSheet070200SummaryTableIncomeExpenditureDto(sheet02);

        allBookDto.setAllSheet0702SummaryTableIncomeDto(allSheet0702SummaryTableIncomeDto);

        /**
         * シート3
         */
        AllSheet0703JournalAndOtherDto allSheet0703JournalAndOtherDto = new AllSheet0703JournalAndOtherDto();
        allSheet0703JournalAndOtherDto.setSheet070300JournalAndOtherDto(new Sheet070300JournalAndOtherDto());
        allBookDto.setAllSheet0703JournalAndOtherDto(allSheet0703JournalAndOtherDto);

        /**
         * シート4
         */
        AllSheet0704BorrowedMoneyDto allSheet0704BorrowedMoneyDto = new AllSheet0704BorrowedMoneyDto();
        allSheet0704BorrowedMoneyDto.setSheet070400BorrowedMoneyDto(new Sheet070400BorrowedMoneyDto());
        allBookDto.setAllSheet0704BorrowedMoneyDto(allSheet0704BorrowedMoneyDto);

        /**
         * シート5
         */
        AllSheet0705IncomeRelatedToGrantsDto allSheet0705IncomeRelatedToGrantsDto = new AllSheet0705IncomeRelatedToGrantsDto();
        allSheet0705IncomeRelatedToGrantsDto
                .setSheet070500IncomeRelatedToGrantsDto(new Sheet070500IncomeRelatedToGrantsDto());
        allBookDto.setAllSheet0705IncomeRelatedToGrantsDto(allSheet0705IncomeRelatedToGrantsDto);

        /**
         * シート6
         */
        AllSheet0706OtherIncomeDto allSheet0706OtherIncomeDto = new AllSheet0706OtherIncomeDto();
        allSheet0706OtherIncomeDto.setSheet070600OtherIncomeDto(new Sheet070600OtherIncomeDto());
        allSheet0706OtherIncomeDto.getSheet070600OtherIncomeDto().setMimanTotal("");
        allBookDto.setAllSheet0706OtherIncomeDto(allSheet0706OtherIncomeDto);

        /**
         * シート7
         */
        AllSheet0707DonateDto allSheet0707DonateDto = new AllSheet0707DonateDto();

        Sheet070701DonatePersonDto sheet070701DonatePersonDto = new Sheet070701DonatePersonDto();
        sheet070701DonatePersonDto.setSonotaTotal("");
        sheet070701DonatePersonDto.setPageTotal(0L);

        Sheet070702DonateGroupDto sheet070702DonateGroupDto = new Sheet070702DonateGroupDto();
        sheet070702DonateGroupDto.setSonotaTotal("");
        sheet070702DonateGroupDto.setPageTotal(0L);

        Sheet070703DonatePoliticOrgDto sheet070703DonatePoliticOrgDto = new Sheet070703DonatePoliticOrgDto();
        sheet070703DonatePoliticOrgDto.setSonotaTotal("");
        sheet070703DonatePoliticOrgDto.setPageTotal(0L);

        AllSheetKbn070701Dto allSheetKbn070701Dto = new AllSheetKbn070701Dto();
        allSheetKbn070701Dto.setSheet070701DonatePersonDto(sheet070701DonatePersonDto);

        AllSheetKbn070702Dto allSheetKbn070702Dto = new AllSheetKbn070702Dto();
        allSheetKbn070702Dto.setSheet070702DonateGroupDto(sheet070702DonateGroupDto);

        AllSheetKbn070703Dto allSheetKbn070703Dto = new AllSheetKbn070703Dto();
        allSheetKbn070703Dto.setSheet070703DonatePoliticOrgDto(sheet070703DonatePoliticOrgDto);

        allSheet0707DonateDto.setAllSheetKbn070701Dto(allSheetKbn070701Dto);
        allSheet0707DonateDto.setAllSheetKbn070702Dto(allSheetKbn070702Dto);
        allSheet0707DonateDto.setAllSheetKbn070703Dto(allSheetKbn070703Dto);

        allBookDto.setAllSheet0707DonateDto(allSheet0707DonateDto);

        /**
         * シート8
         */
        AllSheet0708MediationDto allSheet0708MediationDto = new AllSheet0708MediationDto();

        Sheet070801MediationPersonDto sheet070801MediationPersonDto = new Sheet070801MediationPersonDto();
        sheet070801MediationPersonDto.setSonotaTotal("");
        sheet070801MediationPersonDto.setPageTotal(0L);

        Sheet070802MediationGroupDto sheet070802MediationGroupDto = new Sheet070802MediationGroupDto();
        sheet070802MediationGroupDto.setSonotaTotal("");
        sheet070802MediationGroupDto.setPageTotal(0L);

        Sheet070803MediationPoliticOrgDto sheet070803MediationPoliticOrgDto = new Sheet070803MediationPoliticOrgDto();
        sheet070803MediationPoliticOrgDto.setSonotaTotal("");
        sheet070803MediationPoliticOrgDto.setPageTotal(0L);

        AllSheetKbn070801Dto allSheetKbn070801Dto = new AllSheetKbn070801Dto();
        allSheetKbn070801Dto.setSheet070801MediationPersonDto(sheet070801MediationPersonDto);

        AllSheetKbn070802Dto allSheetKbn070802Dto = new AllSheetKbn070802Dto();
        allSheetKbn070802Dto.setSheet070802MediationGroupDto(sheet070802MediationGroupDto);

        AllSheetKbn070803Dto allSheetKbn070803Dto = new AllSheetKbn070803Dto();
        allSheetKbn070803Dto.setSheet070803MediationPoliticOrgDto(sheet070803MediationPoliticOrgDto);

        allSheet0708MediationDto.setAllSheetKbn070801Dto(allSheetKbn070801Dto);
        allSheet0708MediationDto.setAllSheetKbn070802Dto(allSheetKbn070802Dto);
        allSheet0708MediationDto.setAllSheetKbn070803Dto(allSheetKbn070803Dto);

        allBookDto.setAllSheet0708MediationDto(allSheet0708MediationDto);

        /**
         * シート9
         */
        AllSheet0709AnonymousInPoliticalPartyDto allSheet0709AnonymousInPoliticalPartyDto = new AllSheet0709AnonymousInPoliticalPartyDto();
        allSheet0709AnonymousInPoliticalPartyDto
                .setSheet070900AnonymousInPoliticalPartyDto(new Sheet070900AnonymousInPoliticalPartyDto());
        allBookDto.setAllSheet0709AnonymousInPoliticalPartyDto(allSheet0709AnonymousInPoliticalPartyDto);

        /**
         * シート10
         */
        AllSheet0710SpecificPartyDto allSheet0710SpecificPartyDto = new AllSheet0710SpecificPartyDto();
        allSheet0710SpecificPartyDto.setSheet071000SpecificPartyDto(new Sheet071000SpecificPartyDto());
        allBookDto.setAllSheet0710SpecificPartyDto(allSheet0710SpecificPartyDto);

        /**
         * シート11
         */
        AllSheet0711ConsiderationPartyDto allSheet0711ConsiderationPartyDto = new AllSheet0711ConsiderationPartyDto();

        Sheet071101ConsiderationPartyPerspnalDto sheet071101ConsiderationPartyPerspnalDto = new Sheet071101ConsiderationPartyPerspnalDto();
        sheet071101ConsiderationPartyPerspnalDto.setPartyName("");
        sheet071101ConsiderationPartyPerspnalDto.setSortNo("");
        sheet071101ConsiderationPartyPerspnalDto.setPageTotal(0L);

        Sheet071102ConsiderationPartyGroupDto sheet071102ConsiderationPartyGroupDto = new Sheet071102ConsiderationPartyGroupDto();
        sheet071102ConsiderationPartyGroupDto.setPartyName("");
        sheet071102ConsiderationPartyGroupDto.setSortNo("");
        sheet071102ConsiderationPartyGroupDto.setPageTotal(0L);

        Sheet071103ConsiderationPartyPoliticOrgDto sheet071103ConsiderationPartyPoliticOrgDto = new Sheet071103ConsiderationPartyPoliticOrgDto();
        sheet071103ConsiderationPartyPoliticOrgDto.setPartyName("");
        sheet071103ConsiderationPartyPoliticOrgDto.setSortNo("");
        sheet071103ConsiderationPartyPoliticOrgDto.setPageTotal(0L);

        AllSheetKbn071101Dto allSheetKbn071101Dto = new AllSheetKbn071101Dto();
        allSheetKbn071101Dto.getList().add(sheet071101ConsiderationPartyPerspnalDto);

        AllSheetKbn071102Dto allSheetKbn071102Dto = new AllSheetKbn071102Dto();
        allSheetKbn071102Dto.getList().add(sheet071102ConsiderationPartyGroupDto);

        AllSheetKbn071103Dto allSheetKbn071103Dto = new AllSheetKbn071103Dto();
        allSheetKbn071103Dto.getList().add(sheet071103ConsiderationPartyPoliticOrgDto);

        allSheet0711ConsiderationPartyDto.setAllSheetKbn071101Dto(allSheetKbn071101Dto);
        allSheet0711ConsiderationPartyDto.setAllSheetKbn071102Dto(allSheetKbn071102Dto);
        allSheet0711ConsiderationPartyDto.setAllSheetKbn071103Dto(allSheetKbn071103Dto);

        allBookDto.setAllSheet0711ConsiderationPartyDto(allSheet0711ConsiderationPartyDto);

        /**
         * シート12
         */
        AllSheet0712PartyMediationDto allSheet0712PartyMediationDto = new AllSheet0712PartyMediationDto();

        Sheet071201ConsiderationMediationPartyPersonalDto sheet071201ConsiderationMediationPartyPersonalDto = new Sheet071201ConsiderationMediationPartyPersonalDto();
        sheet071201ConsiderationMediationPartyPersonalDto.setPartyName("");
        sheet071201ConsiderationMediationPartyPersonalDto.setSortNo("");
        sheet071201ConsiderationMediationPartyPersonalDto.setPageTotal(0L);

        Sheet071202ConsiderationMediationPartyGroupDto sheet071202ConsiderationMediationPartyGroupDto = new Sheet071202ConsiderationMediationPartyGroupDto();
        sheet071202ConsiderationMediationPartyGroupDto.setPartyName("");
        sheet071202ConsiderationMediationPartyGroupDto.setSortNo("");
        sheet071202ConsiderationMediationPartyGroupDto.setPageTotal(0L);

        Sheet071203ConsiderationMediationPartyPoliticOrgDto sheet071203ConsiderationMediationPartyPoliticOrgDto = new Sheet071203ConsiderationMediationPartyPoliticOrgDto();
        sheet071203ConsiderationMediationPartyPoliticOrgDto.setPartyName("");
        sheet071203ConsiderationMediationPartyPoliticOrgDto.setSortNo("");
        sheet071203ConsiderationMediationPartyPoliticOrgDto.setPageTotal(0L);

        AllSheetKbn071201Dto allSheetKbn071201Dto = new AllSheetKbn071201Dto();
        allSheetKbn071201Dto.getList().add(sheet071201ConsiderationMediationPartyPersonalDto);

        AllSheetKbn071202Dto allSheetKbn071202Dto = new AllSheetKbn071202Dto();
        allSheetKbn071202Dto.getList().add(sheet071202ConsiderationMediationPartyGroupDto);

        AllSheetKbn071203Dto allSheetKbn071203Dto = new AllSheetKbn071203Dto();
        allSheetKbn071203Dto.getList().add(sheet071203ConsiderationMediationPartyPoliticOrgDto);

        allSheet0712PartyMediationDto.setAllSheetKbn071201Dto(allSheetKbn071201Dto);
        allSheet0712PartyMediationDto.setAllSheetKbn071202Dto(allSheetKbn071202Dto);
        allSheet0712PartyMediationDto.setAllSheetKbn071203Dto(allSheetKbn071203Dto);

        allBookDto.setAllSheet0712PartyMediationDto(allSheet0712PartyMediationDto);

        /**
         * シート13
         */
        AllSheet0713ListOfExpenditureItemsDto allSheet0713ListOfExpenditureItemsDto = new AllSheet0713ListOfExpenditureItemsDto();

        Sheet071300ListOfExpenditureItemsDto sheet13 = new Sheet071300ListOfExpenditureItemsDto();
        sheet13.setGoukeiJinkenhi("");
        sheet13.setKohfuJinkenhi("");
        sheet13.setBikouJinkenhi("");
        sheet13.setGoukeiKohnetsuhi("");
        sheet13.setKohfuKohnetsuhi("");
        sheet13.setBikouKohnetsuhi("");
        sheet13.setGoukeiBihinhi("");
        sheet13.setKohfuBihinhi("");
        sheet13.setBikouBihinhi("");
        sheet13.setGoukeiJimushohi("");
        sheet13.setKohfuJimushohi("");
        sheet13.setBikouJimushohi("");
        sheet13.setGoukeiKeihiShoukei(0L);
        sheet13.setKohfuKeihiShoukei(0L);
        sheet13.setBikouKeihiShoukei("");
        sheet13.setGoukeiSoshikiKatsudouhi(0L);
        sheet13.setKohfuSoshikiKatsudouhi("");
        sheet13.setBikouSoshikiKatsudouhi("");
        sheet13.setGoukeiSenkyoKatsudou(0L);
        sheet13.setKohfuSenkyoKatsudou("");
        sheet13.setBikouSenkyoKatsudou("");
        sheet13.setGoukeiSonota(0L);
        sheet13.setKohfuSonota(0L);
        sheet13.setBikouSonota("");
        sheet13.setGoukeiHakkou(0L);
        sheet13.setKohfuHakkou("");
        sheet13.setBikouHakkou("");
        sheet13.setGoukeiSenden(0L);
        sheet13.setKohfuSenden("");
        sheet13.setBikouSenden("");
        sheet13.setGoukeiKaisaiPty(0L);
        sheet13.setKohfuKaisaiPty("");
        sheet13.setBikouKaisaiPty("");
        sheet13.setGoukeiSonotaJigyou(0L);
        sheet13.setKohfuSonotaJigyou("");
        sheet13.setBikouSonotaJigyou("");
        sheet13.setGoukeiChousaKenkyu(0L);
        sheet13.setKohfuChousaKenkyu("");
        sheet13.setBikouChousaKenkyu("");
        sheet13.setGoukeiKifukin(0L);
        sheet13.setKohfuKifukin("");
        sheet13.setBikouKifukin("");
        sheet13.setGoukeiSonotaKeihi(0L);
        sheet13.setKohfuSonotaKeihi("");
        sheet13.setBikouSonotaKeihi("");
        sheet13.setGoukeiKatsudouhi(0L);
        sheet13.setKohfuKatsudouhi(0L);
        sheet13.setBikouKatsudouhi("");
        sheet13.setGoukeiZenGohkei(0L);

        allSheet0713ListOfExpenditureItemsDto.setSheet071300ListOfExpenditureItemsDto(sheet13);

        allBookDto.setAllSheet0713ListOfExpenditureItemsDto(allSheet0713ListOfExpenditureItemsDto);

        /**
         * シート14
         */
        AllSheet0714ConstsDto allSheet0714ConstsDto = new AllSheet0714ConstsDto();

        Sheet071401UtilityCostsDto sheet071401UtilityCostsDto = new Sheet071401UtilityCostsDto();
        sheet071401UtilityCostsDto.setSonotaTotal("");
        sheet071401UtilityCostsDto.setPageTotal(0L);

        Sheet071402EquipmentCostsDto sheet071402EquipmentCostsDto = new Sheet071402EquipmentCostsDto();
        sheet071402EquipmentCostsDto.setSonotaTotal("");
        sheet071402EquipmentCostsDto.setPageTotal(0L);

        Sheet071403OfficeExpensesDto sheet071403OfficeExpensesDto = new Sheet071403OfficeExpensesDto();
        sheet071403OfficeExpensesDto.setSonotaTotal("");
        sheet071403OfficeExpensesDto.setPageTotal(0L);

        AllSheetKbn071401Dto allSheetKbn071401Dto = new AllSheetKbn071401Dto();
        allSheetKbn071401Dto.setSheet071401UtilityCostsDto(sheet071401UtilityCostsDto);

        AllSheetKbn071402Dto allSheetKbn071402Dto = new AllSheetKbn071402Dto();
        allSheetKbn071402Dto.setSheet071402EquipmentCostsDto(sheet071402EquipmentCostsDto);

        AllSheetKbn071403Dto allSheetKbn071403Dto = new AllSheetKbn071403Dto();
        allSheetKbn071403Dto.setSheet071403OfficeExpensesDto(sheet071403OfficeExpensesDto);

        allSheet0714ConstsDto.setAllSheetKbn071401Dto(allSheetKbn071401Dto);
        allSheet0714ConstsDto.setAllSheetKbn071402Dto(allSheetKbn071402Dto);
        allSheet0714ConstsDto.setAllSheetKbn071403Dto(allSheetKbn071403Dto);

        allBookDto.setAllSheet0714ConstsDto(allSheet0714ConstsDto);

        /**
         * シート15
         */
        AllSheet0715ExpenseDto allSheet0715ExpenseDto = new AllSheet0715ExpenseDto();

        Sheet071501OrganizationalActivityExpensesDto sheet071501OrganizationalActivityExpensesDto = new Sheet071501OrganizationalActivityExpensesDto();
        sheet071501OrganizationalActivityExpensesDto.setSonotaTotal("");
        sheet071501OrganizationalActivityExpensesDto.setHimoku("");
        sheet071501OrganizationalActivityExpensesDto.setPageTotal(0L);

        Sheet071502ElectionRelatedExpensesDto sheet071502ElectionRelatedExpensesDto = new Sheet071502ElectionRelatedExpensesDto();
        sheet071502ElectionRelatedExpensesDto.setSonotaTotal("");
        sheet071502ElectionRelatedExpensesDto.setHimoku("");
        sheet071502ElectionRelatedExpensesDto.setPageTotal(0L);

        Sheet071503MagazinePublicationExpensesDto sheet071503MagazinePublicationExpensesDto = new Sheet071503MagazinePublicationExpensesDto();
        sheet071503MagazinePublicationExpensesDto.setSonotaTotal("");
        sheet071503MagazinePublicationExpensesDto.setHimoku("");
        sheet071503MagazinePublicationExpensesDto.setPageTotal(0L);

        Sheet071504AdvertisingExpensesDto sheet071504AdvertisingExpensesDto = new Sheet071504AdvertisingExpensesDto();
        sheet071504AdvertisingExpensesDto.setSonotaTotal("");
        sheet071504AdvertisingExpensesDto.setHimoku("");
        sheet071504AdvertisingExpensesDto.setPageTotal(0L);

        Sheet071505PartyHostingFeeDto sheet071505PartyHostingFeeDto = new Sheet071505PartyHostingFeeDto();
        sheet071505PartyHostingFeeDto.setSonotaTotal("");
        sheet071505PartyHostingFeeDto.setHimoku("");
        sheet071505PartyHostingFeeDto.setPageTotal(0L);

        Sheet071506OtherBusinessExpensesDto sheet071506OtherBusinessExpensesDto = new Sheet071506OtherBusinessExpensesDto();
        sheet071506OtherBusinessExpensesDto.setSonotaTotal("");
        sheet071506OtherBusinessExpensesDto.setHimoku("");
        sheet071506OtherBusinessExpensesDto.setPageTotal(0L);

        Sheet071507ResearchExpensesDto sheet071507ResearchExpensesDto = new Sheet071507ResearchExpensesDto();
        sheet071507ResearchExpensesDto.setSonotaTotal("");
        sheet071507ResearchExpensesDto.setHimoku("");
        sheet071507ResearchExpensesDto.setPageTotal(0L);

        Sheet071508DonationsGrantsDto sheet071508DonationsGrantsDto = new Sheet071508DonationsGrantsDto();
        sheet071508DonationsGrantsDto.setSonotaTotal("");
        sheet071508DonationsGrantsDto.setHimoku("");
        sheet071508DonationsGrantsDto.setPageTotal(0L);

        Sheet071509OtherExpensesDto sheet071509OtherExpensesDto = new Sheet071509OtherExpensesDto();
        sheet071509OtherExpensesDto.setSonotaTotal("");
        sheet071509OtherExpensesDto.setHimoku("");
        sheet071509OtherExpensesDto.setPageTotal(0L);

        AllSheetKbn071501Dto allSheetKbn071501Dto = new AllSheetKbn071501Dto();
        allSheetKbn071501Dto.getList().add(sheet071501OrganizationalActivityExpensesDto);

        AllSheetKbn071502Dto allSheetKbn071502Dto = new AllSheetKbn071502Dto();
        allSheetKbn071502Dto.getList().add(sheet071502ElectionRelatedExpensesDto);

        AllSheetKbn071503Dto allSheetKbn071503Dto = new AllSheetKbn071503Dto();
        allSheetKbn071503Dto.getList().add(sheet071503MagazinePublicationExpensesDto);

        AllSheetKbn071504Dto allSheetKbn071504Dto = new AllSheetKbn071504Dto();
        allSheetKbn071504Dto.getList().add(sheet071504AdvertisingExpensesDto);

        AllSheetKbn071505Dto allSheetKbn071505Dto = new AllSheetKbn071505Dto();
        allSheetKbn071505Dto.getList().add(sheet071505PartyHostingFeeDto);

        AllSheetKbn071506Dto allSheetKbn071506Dto = new AllSheetKbn071506Dto();
        allSheetKbn071506Dto.getList().add(sheet071506OtherBusinessExpensesDto);

        AllSheetKbn071507Dto allSheetKbn071507Dto = new AllSheetKbn071507Dto();
        allSheetKbn071507Dto.getList().add(sheet071507ResearchExpensesDto);

        AllSheetKbn071508Dto allSheetKbn071508Dto = new AllSheetKbn071508Dto();
        allSheetKbn071508Dto.getList().add(sheet071508DonationsGrantsDto);

        AllSheetKbn071509Dto allSheetKbn071509Dto = new AllSheetKbn071509Dto();
        allSheetKbn071509Dto.getList().add(sheet071509OtherExpensesDto);

        allSheet0715ExpenseDto.setAllSheetKbn071501Dto(allSheetKbn071501Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071502Dto(allSheetKbn071502Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071503Dto(allSheetKbn071503Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071504Dto(allSheetKbn071504Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071505Dto(allSheetKbn071505Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071506Dto(allSheetKbn071506Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071507Dto(allSheetKbn071507Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071508Dto(allSheetKbn071508Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071509Dto(allSheetKbn071509Dto);

        allBookDto.setAllSheet0715ExpenseDto(allSheet0715ExpenseDto);

        /**
         * シート16
         */
        AllSheet0716RelatedToGrantsDtoDto allSheet0716RelatedToGrantsDtoDto = new AllSheet0716RelatedToGrantsDtoDto();
        allSheet0716RelatedToGrantsDtoDto
                .setSheet071600ExpendituresRelatedToGrantsDto(new Sheet071600ExpendituresRelatedToGrantsDto());
        allBookDto.setAllSheet0716RelatedToGrantsDtoDto(allSheet0716RelatedToGrantsDtoDto);

        /**
         * シート17
         */
        AllSheet0717SummaryTableOfAssetsDto allSheet0717SummaryTableOfAssetsDto = new AllSheet0717SummaryTableOfAssetsDto();
        Sheet071700SummaryTableOfAssetsDto sheet17 = new Sheet071700SummaryTableOfAssetsDto();
        sheet17.setFlgTochi(0);
        sheet17.setBikouTochi("");
        sheet17.setFlgTatemono(0);
        sheet17.setBikouTatemono("");
        sheet17.setFlgShakuchiken(0);
        sheet17.setBikouShakuchiken("");
        sheet17.setFlgDohsan(0);
        sheet17.setBikouDohsan("");
        sheet17.setFlgYokin(0);
        sheet17.setBikouYokin("");
        sheet17.setFlgShintaku(0);
        sheet17.setBikouShintaku("");
        sheet17.setFlgShouken(0);
        sheet17.setBikouShouken("");
        sheet17.setFlgShusshi(0);
        sheet17.setBikouShusshi("");
        sheet17.setFlgKashitsuke(0);
        sheet17.setBikouKashitsuke("");
        sheet17.setFlgShikikin(0);
        sheet17.setBikouShikikin("");
        sheet17.setFlgShisetsuRiyou(0);
        sheet17.setBikouShisetsuRiyou("");
        sheet17.setFlgKairiire(0);
        sheet17.setBikouKariire("");

        allSheet0717SummaryTableOfAssetsDto.setSheet071700SummaryTableOfAssetsDto(sheet17);

        allBookDto.setAllSheet0717SummaryTableOfAssetsDto(allSheet0717SummaryTableOfAssetsDto);

        /**
         * シート18
         */

        AllSheet0718AssetsDto allSheet0718AssetsDto = new AllSheet0718AssetsDto();

        Sheet071801LandAmongAssetsDto sheet071801LandAmongAssetsDto = new Sheet071801LandAmongAssetsDto();
        Sheet071802BuildingsAmongAssetsDto sheet071802BuildingsAmongAssetsDto = new Sheet071802BuildingsAmongAssetsDto();
        Sheet071803SurfaceRightsAmongAssetsDto sheet071803SurfaceRightsAmongAssetsDto = new Sheet071803SurfaceRightsAmongAssetsDto();
        Sheet071804MovablesAmongAssetsDto sheet071804MovablesAmongAssetsDto = new Sheet071804MovablesAmongAssetsDto();
        Sheet071805SavingsAmmongAssetsDto sheet071805SavingsAmmongAssetsDto = new Sheet071805SavingsAmmongAssetsDto();
        Sheet071806TrustAmongAssetsDto sheet071806TrustAmongAssetsDto = new Sheet071806TrustAmongAssetsDto();
        Sheet071807SecuritiesAmongAssetsDto sheet071807SecuritiesAmongAssetsDto = new Sheet071807SecuritiesAmongAssetsDto();
        Sheet071808InvestmentAmongAssetsDto sheet071808InvestmentAmongAssetsDto = new Sheet071808InvestmentAmongAssetsDto();
        Sheet071809LoanAmongAssetsDto sheet071809LoanAmongAssetsDto = new Sheet071809LoanAmongAssetsDto();
        Sheet071810DepositAmongAssetsDto sheet071810DepositAmongAssetsDto = new Sheet071810DepositAmongAssetsDto();
        Sheet071811FacilityUsageRightsAmongAssetsDto sheet071811FacilityUsageRightsAmongAssetsDto = new Sheet071811FacilityUsageRightsAmongAssetsDto();
        Sheet071812BorrowingsAmongAssetsDto sheet071812BorrowingsAmongAssetsDto = new Sheet071812BorrowingsAmongAssetsDto();

        AllSheetKbn071801Dto allSheetKbn071801Dto = new AllSheetKbn071801Dto();
        allSheetKbn071801Dto.setSheet071801LandAmongAssetsDto(sheet071801LandAmongAssetsDto);

        AllSheetKbn071802Dto allSheetKbn071802Dto = new AllSheetKbn071802Dto();
        allSheetKbn071802Dto.setSheet071802BuildingsAmongAssetsDto(sheet071802BuildingsAmongAssetsDto);

        AllSheetKbn071803Dto allSheetKbn071803Dto = new AllSheetKbn071803Dto();
        allSheetKbn071803Dto.setSheet071803SurfaceRightsAmongAssetsDto(sheet071803SurfaceRightsAmongAssetsDto);

        AllSheetKbn071804Dto allSheetKbn071804Dto = new AllSheetKbn071804Dto();
        allSheetKbn071804Dto.setSheet071804MovablesAmongAssetsDto(sheet071804MovablesAmongAssetsDto);

        AllSheetKbn071805Dto allSheetKbn071805Dto = new AllSheetKbn071805Dto();
        allSheetKbn071805Dto.setSheet071805SavingsAmmongAssetsDto(sheet071805SavingsAmmongAssetsDto);

        AllSheetKbn071806Dto allSheetKbn071806Dto = new AllSheetKbn071806Dto();
        allSheetKbn071806Dto.setSheet071806TrustAmongAssetsDto(sheet071806TrustAmongAssetsDto);

        AllSheetKbn071807Dto allSheetKbn071807Dto = new AllSheetKbn071807Dto();
        allSheetKbn071807Dto.setSheet071807SecuritiesAmongAssetsDto(sheet071807SecuritiesAmongAssetsDto);

        AllSheetKbn071808Dto allSheetKbn071808Dto = new AllSheetKbn071808Dto();
        allSheetKbn071808Dto.setSheet071808InvestmentAmongAssetsDto(sheet071808InvestmentAmongAssetsDto);

        AllSheetKbn071809Dto allSheetKbn071809Dto = new AllSheetKbn071809Dto();
        allSheetKbn071809Dto.setSheet071809LoanAmongAssetsDto(sheet071809LoanAmongAssetsDto);

        AllSheetKbn071810Dto allSheetKbn071810Dto = new AllSheetKbn071810Dto();
        allSheetKbn071810Dto.setSheet071810DepositAmongAssetsDto(sheet071810DepositAmongAssetsDto);

        AllSheetKbn071811Dto allSheetKbn071811Dto = new AllSheetKbn071811Dto();
        allSheetKbn071811Dto
                .setSheet071811FacilityUsageRightsAmongAssetsDto(sheet071811FacilityUsageRightsAmongAssetsDto);

        AllSheetKbn071812Dto allSheetKbn071812Dto = new AllSheetKbn071812Dto();
        allSheetKbn071812Dto.setSheet071812BorrowingsAmongAssetsDto(sheet071812BorrowingsAmongAssetsDto);

        allSheet0718AssetsDto.setAllSheetKbn071801Dto(allSheetKbn071801Dto);
        allSheet0718AssetsDto.setAllSheetKbn071802Dto(allSheetKbn071802Dto);
        allSheet0718AssetsDto.setAllSheetKbn071803Dto(allSheetKbn071803Dto);
        allSheet0718AssetsDto.setAllSheetKbn071804Dto(allSheetKbn071804Dto);
        allSheet0718AssetsDto.setAllSheetKbn071805Dto(allSheetKbn071805Dto);
        allSheet0718AssetsDto.setAllSheetKbn071806Dto(allSheetKbn071806Dto);
        allSheet0718AssetsDto.setAllSheetKbn071807Dto(allSheetKbn071807Dto);
        allSheet0718AssetsDto.setAllSheetKbn071808Dto(allSheetKbn071808Dto);
        allSheet0718AssetsDto.setAllSheetKbn071809Dto(allSheetKbn071809Dto);
        allSheet0718AssetsDto.setAllSheetKbn071810Dto(allSheetKbn071810Dto);
        allSheet0718AssetsDto.setAllSheetKbn071811Dto(allSheetKbn071811Dto);
        allSheet0718AssetsDto.setAllSheetKbn071812Dto(allSheetKbn071812Dto);

        allBookDto.setAllSheet0718AssetsDto(allSheet0718AssetsDto);

        /**
         * シート19
         */
        AllSheet0719RealEstateDto allSheet0719RealEstateDto = new AllSheet0719RealEstateDto();
        allSheet0719RealEstateDto.getListSheet0719().add(new Sheet071900RealEstateDto());
        allSheet0719RealEstateDto.getListSheet0719().get(0).setKbnRealEstitate(0);
        allBookDto.setAllSheet0719RealEstateDto(allSheet0719RealEstateDto);

        /**
         * シート20
         */
        AllSheet0720OathDto allSheet0720OathDto = new AllSheet0720OathDto();
        Sheet072000OathDto sheet20 = new Sheet072000OathDto();
        sheet20.setFlgReciptCopy(0);
        sheet20.setFlgKansaIkensho(0);
        sheet20.setFlgSeijishikinHohkokusho(0);
        sheet20.setDateOath("R3/10/31");
        sheet20.setDantaiName("サンプル政治団体");
        sheet20.setKaikeiSekininshaNameLast("会計責任者");
        sheet20.setKaikeiSekininshaNameFirst("花子");
        sheet20.setDaihyoushaNameLast("");
        sheet20.setDaihyoushaNameFirst("");

        allSheet0720OathDto.setSheet072000OathDto(sheet20);

        allBookDto.setAllSheet0720OathDto(allSheet0720OathDto);

        /**
         * シート8
         */
        AllSheet0800DifficultCollectReceiptDto allSheet0800DifficultCollectReceiptDto = new AllSheet0800DifficultCollectReceiptDto();
        allSheet0800DifficultCollectReceiptDto
                .setSheet080000DifficultCollectReceiptDto(new Sheet080000DifficultCollectReceiptDto());
        allBookDto.setAllSheet0800DifficultCollectReceiptDto(allSheet0800DifficultCollectReceiptDto);

        /**
         * シート8その2
         */
        AllSheet0802WithdrawalItemsByTransferDto allSheet0802WithdrawalItemsByTransferDto = new AllSheet0802WithdrawalItemsByTransferDto();
        allBookDto.setAllSheet0802WithdrawalItemsByTransferDto(allSheet0802WithdrawalItemsByTransferDto);

        /**
         * シート租税特別措置
         */
        AllSheet411710DonationClassifyDto allSheet411710DonationClassifyDto = new AllSheet411710DonationClassifyDto();

        RowSozei411713SupportingMembersParliamentDto row13 = new RowSozei411713SupportingMembersParliamentDto();
        row13.setGiinName("");

        RowSozei411714SupportingLocalLegislatorsDto row14 = new RowSozei411714SupportingLocalLegislatorsDto();
        row14.setName("");
        row14.setSenkyo("");
        row14.setDate("");

        Sheet411710DonationClassifyDto sheet411710DonationClassifyDto = new Sheet411710DonationClassifyDto();
        sheet411710DonationClassifyDto.setKubun(0);
        sheet411710DonationClassifyDto.setRowSozei411713SupportingMembersParliamentDto(row13);
        sheet411710DonationClassifyDto.setRowSozei411714SupportingLocalLegislatorsDto(row14);

        allSheet411710DonationClassifyDto.setSheet411710DonationClassifyDto(sheet411710DonationClassifyDto);

        allBookDto.setAllSheet411710DonationClassifyDto(allSheet411710DonationClassifyDto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml0 = xmlMapper.writeValueAsString(allBookDto);

        Path pathAnswer0 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/SYUUSI_least_change.txt");
        String answer0 = Files.readString(pathAnswer0);

        assertThat(xml0).isEqualTo(answer0);

    }
}
