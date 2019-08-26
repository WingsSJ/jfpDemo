package fortest;

import lombok.Data;

@Data
public class MobiToken {
    private String ptoken;
    private String expire;
    private String accountid;

    public MobiToken(String ptoken, String expire, String accountid) {
        this.ptoken = ptoken;
        this.expire = expire;
        this.accountid = accountid;
    }

}
