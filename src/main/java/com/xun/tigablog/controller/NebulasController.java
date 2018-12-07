package com.xun.tigablog.controller;

import io.nebulas.client.NebulasClient;
import io.nebulas.client.api.request.CallRequest;
import io.nebulas.client.api.request.Contract;
import io.nebulas.client.api.request.GetAccountStateRequest;
import io.nebulas.client.api.response.AccountState;
import io.nebulas.client.api.response.CallResult;
import io.nebulas.client.api.response.Response;
import io.nebulas.client.impl.HttpNebulasClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class NebulasController {
    private NebulasClient nebulasClient = HttpNebulasClient.create("https://mainnet.nebulas.io");

    /**
     * 获得指定地址里面的余额
     *
     * @param address
     * @return
     */
    @GetMapping("/nebulas/getAccountBalance")
    public String getAccountBalance(@RequestParam(name = "address") String address) {
        Response<AccountState> response = nebulasClient.getAccountState(new GetAccountStateRequest(address));
        return String.valueOf(response.getResult().getBalance());
    }


    /**
     * 调用星云链上指定合约的指定方法
     *
     * @param address
     * @param contactAddress
     * @param value
     * @param funcName
     * @param funcArgs
     * @return
     */
    @PostMapping(value = "/nebulas/contactCall")
    public String contactCall(@RequestParam(name = "address") String address,
                              @RequestParam(name = "contactAddress") String contactAddress,
                              @RequestParam(name = "value") String value,
                              @RequestParam(name = "funcName") String funcName,
                              @RequestParam(name = "funcArgs") String funcArgs) {
        Response<CallResult> response =
                nebulasClient.call(new CallRequest(address, contactAddress, value, 3L, "1000000", "20000000", new Contract().setFunction(funcName).setArgs(funcArgs)));
        return response.getResult().getResult();
    }
}
