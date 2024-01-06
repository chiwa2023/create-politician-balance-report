package mitei.mitei.create.report.balance.politician.dto.publish;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 様式17その18の09 資産のうち(返済される)貸付を表すワークシートDto
 */
@JacksonXmlRootElement(localName = "SHEET")
public class Sheet071809LoanAmongAssetsDto extends Template0718SheetDto implements Serializable {

    /** serialId */
    private static final long serialVersionUID = 1L;

}
