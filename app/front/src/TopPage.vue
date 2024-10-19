<script setup lang="ts">
import TopInfo from './components/common/top_info/TopInfo.vue';
import CheckPrivilegeDto from './dto/common_check/checkPrivilegeDto';
import CheckSecurityDto from './dto/common_check/checkSecurityDto';
import SessionStorageCommonCheck from './dto/common_check/sessionStorageCommonCheck';
import { useRouter } from "vue-router";

//router    
const routerDestination = useRouter();//遷移先への移動用





//仮でサンプルユーザを設定 TODO 機能実装次第削除する
const loginUserId: number = 1007;
const loginUserCode: number = 995;
const loginUserName: string = "会計責任者 正夫";
//const politicalOrganizationId: number = 2345;
//const politicalOrganizationCode: number = 2333;
//const politicalOrganizationName: string = "サンプル政治団体";

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
//checkPrivilegeDto.politicalOrganizationId = politicalOrganizationId;
//checkPrivilegeDto.politicalOrganizationCode = politicalOrganizationCode;
//checkPrivilegeDto.politicalOrganizationName = politicalOrganizationName;

//セッションストレージ保存
SessionStorageCommonCheck.setSecurity(checkSecurityDto);
SessionStorageCommonCheck.setPrivilege(checkPrivilegeDto);

// 直接アクセスしかされないので、ログインされているかをチェックする
// ログインされていない場合はログインページへ
const securityDto: CheckSecurityDto = SessionStorageCommonCheck.getSecurity();
if (0 === securityDto.loginUserId) {
    // loginUserIdが0=初期値の場合は、ログインしていないのでログインページに遷移する
    routerDestination.push("/login_user"+"?directPath=/");
}

</script>
<template>
    <!-- トップ情報 -->
    <TopInfo></TopInfo>

    <h1>(仮)Top Page</h1>

    <RouterLink to="/login_user">ユーザログイン</RouterLink><br>

    <RouterLink to="/component">コンポーネント作成台紙</RouterLink><br>

</template>
<style scoped></style>