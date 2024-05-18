<script setup lang="ts">
import CheckSecurityDto from "./dto/common_check/checkSecurityDto";
import CheckPrivilegeDto from "./dto/common_check/checkPrivilegeDto";
import SessionStorageCommonCheck from "./dto/common_check/sessionStorageCommonCheck";

//本来はログインページで設定されているセキュリティ・権限情報は
//未実装のため、このページで落ちない形で実装する。
//TODO ログインの仕様が決定次第修正する
/* 値設定は基本的に1回のみ */

//ログイン成功したユーザ想定
//        checkPrivilegeDto.setLoginUserId(1007L); // CHECKSTYLE:OFF
//        checkPrivilegeDto.setLoginUserCode(995); // CHECKSTYLE:OFF
//        checkPrivilegeDto.setPoliticalOrganizationId(2345L); // CHECKSTYLE:OFF
//        checkPrivilegeDto.setPoliticalOrganizationCode(2333); // CHECKSTYLE:OFF
//        checkPrivilegeDto.setPoliticalOrganizationName("サンプル政治団体");
const loginUserId:number = 1007;
const loginUserCode:number = 995;
const loginUserName:string = "会計責任者 正夫";
const politicalOrganizationId:number = 2345;
const politicalOrganizationCode:number = 2333;
const politicalOrganizationName:string = "サンプル政治団体";

//落ちない値を設定したセキュリティDto
const checkSecurityDto: CheckSecurityDto = new CheckSecurityDto();
checkSecurityDto.isRaiseExcception = false;
checkSecurityDto.isResult = true;
checkSecurityDto.loginUserId = loginUserId;
checkSecurityDto.loginUserCode = loginUserCode;

//落ちない値を設定した権限Dto
const checkPrivilegeDto: CheckPrivilegeDto = new CheckPrivilegeDto();
checkPrivilegeDto.isRaiseExcception = false;
checkPrivilegeDto.isResult = true;
checkPrivilegeDto.loginUserId = loginUserId;
checkPrivilegeDto.loginUserCode = loginUserCode;
checkPrivilegeDto.loginUserName = loginUserName;
checkPrivilegeDto.politicalOrganizationId = politicalOrganizationId;
checkPrivilegeDto.politicalOrganizationCode = politicalOrganizationCode;
checkPrivilegeDto.politicalOrganizationName = politicalOrganizationName;

//セッションストレージ保存
SessionStorageCommonCheck.setSecurity(checkSecurityDto);
SessionStorageCommonCheck.setPrivilege(checkPrivilegeDto);
/* ここまで */

</script>
<template>
    <h1>(仮)Top Page</h1>
    <RouterLink to="/read_fin_institution_csv">一般CSVを読みとってデータの仕分けをする</RouterLink><br>
    <RouterLink to="/meeting_adjust_income">意見付記履歴を参照して編集(収入項目)</RouterLink><br>
    <RouterLink to="/meeting_adjust_outcome">意見付記履歴を参照して編集(支出項目)</RouterLink><br>
    <RouterLink to="/publish_submisson">発行した収支報告書XMLを提出する</RouterLink><br>
    <RouterLink to="/component">コンポーネント作成台紙</RouterLink><br>

</template>
<style scoped></style>
