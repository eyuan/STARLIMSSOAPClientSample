package com.lims.starlims;

import com.starlims.webservices.GenericServicesSoapProxy;

import java.rmi.RemoteException;

public class Main {
    //url
    public static String url = "http://ip:port/website/SERVICES/GENERIC.ASMX";
    public static String username = "username";
    public static String password = "password";
    //test login
    public static void userLoginTest() throws RemoteException {
        GenericServicesSoapProxy lims = new GenericServicesSoapProxy();
        lims.setEndpoint(url);
        boolean rst = lims.userLogin(username, password);
        System.out.println("lgoin result"+rst);
    }
    //test call starlims server script
    public static void runActionTest() throws RemoteException {
        GenericServicesSoapProxy lims = new GenericServicesSoapProxy();
        lims.setEndpoint(url);
        //server script url
        String actionID = "lims.test";
        //parameters
        Object[] parameters = new Object[4];
        parameters[0] = "字符串";
        parameters[1] = 0;
        parameters[2] = false;
        Object[] objArr = new Object[3];//嵌套数组
        objArr[0] = "字符串";
        objArr[1] = 1;
        objArr[2] = true;
        parameters[3] = objArr;
        //call web service
        Object rstObj = lims.runActionDirect(actionID, parameters, username, password);
        //result type convert
        Object[] rstArr = (Object[]) rstObj;//any type
        //
        System.out.println(rstArr[0]);
        System.out.println(rstArr[1]);
    }

    public static void main(String[] args) throws RemoteException {
        userLoginTest();
//        runActionTest();
    }
}
