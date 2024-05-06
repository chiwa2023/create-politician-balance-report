import PropseCsvReadTemplateEntity from "../../entity/proposeCsvReadTemplateEntity";
import AbstactCapsuleDto from "../abstactCapsuleDto";

export default class RegistProposeCsvReadRemplateCapsuleDto extends AbstactCapsuleDto{

    /** csv読み取り仕様利用申請Entity */
    proposeCsvReadTemplateEntity: PropseCsvReadTemplateEntity;
    
    constructor() {
        super();
        this.proposeCsvReadTemplateEntity = new PropseCsvReadTemplateEntity();
    }


}