package LightShineComeSession.LightShineComeSessionYxd;

import java.io.File;
import java.io.IOException;

import com.yxd.hadoop.test.Func.Computer;
import com.yxd.hadoop.test.buyticket.ThreadPoolExecutorManage;
import com.yxd.hadoop.test.buyticket.TicketManage;
import com.yxd.hadoop.test.object.CPUInfo;
import com.yxd.hadoop.test.object.CopyFile;
import com.yxd.hadoop.test.object.EMSInfo;
import com.yxd.hadoop.test.object.GetNoWeekOfYear;
import com.yxd.hadoop.test.object.HardDiskInfo;
import com.yxd.hadoop.test.object.YangXiaoDong;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
     
    }

    public void testThreadPoolExecutorManage(){
    	TicketManage.simulationBuyTicket();
    }
    /*public void testCopyFile(){
    	
    	CopyFile cf =new CopyFile();
    	try {
			cf.copyFileByBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }*/
  /*  public void testGetNoWeekOfYear(){
    	GetNoWeekOfYear GetNoWeekOfYear = new GetNoWeekOfYear();
    	GetNoWeekOfYear.noWeekByNow();
    }*/
    
  /*  public void testYxd(){
    	YangXiaoDong yxd = new YangXiaoDong();
    	yxd.subStringByNumber();
    }*/
    
   /* public void  computerTest(){
    	//cpu信息
    	CPUInfo cpu = new CPUInfo("联想","2.5GHZ");
    	EMSInfo eMSInfo  =new EMSInfo("波士顿", "8G");
    	HardDiskInfo hardDiskInfo = new HardDiskInfo("250G");
    	//组装计算机
    	Computer computer = new Computer(cpu, eMSInfo, hardDiskInfo);
    	//输出计算机配置信息
    	computer.display();
    }*/
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    { 
        assertTrue( true );
    }
    
   
}
