package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.publish.AllBookDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0707DonateDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0708MediationDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0711ConsiderationPartyDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0712PartyMediationDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0714ConstsDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0715ExpenseDto;
import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0718AssetsDto;

/**
 * MakeUmuInputTextLogic単体テスト
 */
class MakeUmuInputTextLogicTest {
//CHECKSTYLE:OFF

    @Test
    void test() {
        // TODO 妥当性Logicがすべて実装できたら作製する
        // MakeUmuInputTextLogic makeUmuInputTextLogic = new MakeUmuInputTextLogic();
        // AllBookDto allBookDto = new AllBookDto();

        fail("Not yet implemented");
    }

    @Test
    void convertTextTest() throws Exception {

        /** 与えられた配列からフラグテキストを生成できるかだけをチェック */
        final Method method = MakeUmuInputTextLogic.class.getDeclaredMethod("convertText", int[].class);
        method.setAccessible(true); // NOPMD

        MakeUmuInputTextLogic makeUmuInputTextLogic = new MakeUmuInputTextLogic();
        int[] data1 = { 1, 1, 1, 1, 1 };

        StringBuilder ans1 = (StringBuilder) method.invoke(makeUmuInputTextLogic, data1);
        assertThat(ans1.toString()).isEqualTo("11111");

        int[] data2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        StringBuilder ans2 = (StringBuilder) method.invoke(makeUmuInputTextLogic, data2);
        assertThat(ans2.toString()).isEqualTo("000000000");

        // 0,1以外は対象外
        int[] data3 = { 0, 4, 0, 1, 0, 9 };
        //このテストではthrow IllegalArgumentExceptionに基づくInvocationTargetExceptionが投げられる
        assertThrows(InvocationTargetException.class, () -> method.invoke(makeUmuInputTextLogic, data3));
        //assertThrows(IllegalArgumentException.class, () -> method.invoke(makeUmuInputTextLogic, data3));
    }

    @Test
    void confimInputUmuTest() throws Exception { //NOPMD
        
        /**
         * 妥当性Logic(private Validate.....Logic validate...)が指定位置にセットされているかだけをチェック
         * 現段階では実装がまだなのでMockLogicで検査。本番ではMockをはずす(isNotRunBoot)
         * TODO Mockを起動しなくなったらこのテストも入れ替えする 
         */
        
        final Method method = MakeUmuInputTextLogic.class.getDeclaredMethod("confimInputUmu", AllBookDto.class);
        method.setAccessible(true); // NOPMD

        MakeUmuInputTextLogic makeUmuInputTextLogic = new MakeUmuInputTextLogic();

        AllBookDto allBookDto = new AllBookDto();
        allBookDto.setAllSheet0707DonateDto(new AllSheet0707DonateDto());
        allBookDto.setAllSheet0708MediationDto(new AllSheet0708MediationDto());
        allBookDto.setAllSheet0711ConsiderationPartyDto(new AllSheet0711ConsiderationPartyDto());
        allBookDto.setAllSheet0712PartyMediationDto(new AllSheet0712PartyMediationDto());
        allBookDto.setAllSheet0714ConstsDto(new AllSheet0714ConstsDto());
        allBookDto.setAllSheet0715ExpenseDto(new AllSheet0715ExpenseDto());
        allBookDto.setAllSheet0718AssetsDto(new AllSheet0718AssetsDto());
        
        int[] data = (int[]) method.invoke(makeUmuInputTextLogic, allBookDto);

        assertThat(data[0]).isEqualTo(70100);
        assertThat(data[1]).isEqualTo(70200);
        assertThat(data[2]).isEqualTo(70300);
        assertThat(data[3]).isEqualTo(70400);
        assertThat(data[4]).isEqualTo(70500);
        assertThat(data[5]).isEqualTo(70600);
        assertThat(data[6]).isEqualTo(70701);
        assertThat(data[7]).isEqualTo(70702);
        assertThat(data[8]).isEqualTo(70703);
        assertThat(data[9]).isEqualTo(70801);
        assertThat(data[10]).isEqualTo(70802);
        assertThat(data[11]).isEqualTo(70803);
        assertThat(data[12]).isEqualTo(70900);
        assertThat(data[13]).isEqualTo(71000);
        assertThat(data[14]).isEqualTo(71101);
        assertThat(data[15]).isEqualTo(71102);
        assertThat(data[16]).isEqualTo(71103);
        assertThat(data[17]).isEqualTo(71201);
        assertThat(data[18]).isEqualTo(71202);
        assertThat(data[19]).isEqualTo(71203);
        assertThat(data[20]).isEqualTo(71300);
        assertThat(data[21]).isEqualTo(71401);
        assertThat(data[22]).isEqualTo(71402);
        assertThat(data[23]).isEqualTo(71403);
        assertThat(data[24]).isEqualTo(71501);
        assertThat(data[25]).isEqualTo(71502);
        assertThat(data[26]).isEqualTo(71503);
        assertThat(data[27]).isEqualTo(71504);
        assertThat(data[28]).isEqualTo(71505);
        assertThat(data[29]).isEqualTo(71506);
        assertThat(data[30]).isEqualTo(71507);
        assertThat(data[31]).isEqualTo(71508);
        assertThat(data[32]).isEqualTo(71509);
        assertThat(data[33]).isEqualTo(71600);
        assertThat(data[34]).isEqualTo(71700);
        assertThat(data[35]).isEqualTo(71801);
        assertThat(data[36]).isEqualTo(71802);
        assertThat(data[37]).isEqualTo(71803);
        assertThat(data[38]).isEqualTo(71804);
        assertThat(data[39]).isEqualTo(71805);
        assertThat(data[40]).isEqualTo(71806);
        assertThat(data[41]).isEqualTo(71807);
        assertThat(data[42]).isEqualTo(71808);
        assertThat(data[43]).isEqualTo(71809);
        assertThat(data[44]).isEqualTo(71810);
        assertThat(data[45]).isEqualTo(71811);
        assertThat(data[46]).isEqualTo(71812);
        assertThat(data[47]).isEqualTo(71900);
        assertThat(data[48]).isEqualTo(72000);
        assertThat(data[49]).isEqualTo(80000);
        assertThat(data[50]).isEqualTo(80200);

    }

}
