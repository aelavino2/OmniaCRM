package com.omniacrm.core.system;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.omniacrm.contracts.api.SystemApi;
import com.omniacrm.contracts.model.PingResponse;

@RestController
class PingController implements SystemApi {

    @Override
    public ResponseEntity<PingResponse> ping() {
        return ResponseEntity.ok(new PingResponse("ok"));
    }
}
