package vpn;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by wangpeng on 2015/7/5.
 */
public class TestVPN {

    @Test
    public void connectVPN() throws IOException {
        //rasdial command line
        VPNUtil.connectVPN("FUJI","hjbd","hjbd");
    }

    @Test
    public void disconnectVPN() throws IOException {
        //rasdial command line
        VPNUtil.disconnectVPN("FUJI");
    }
}
