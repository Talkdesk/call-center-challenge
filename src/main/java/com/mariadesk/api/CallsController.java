package com.mariadesk.api;

import com.mariadesk.models.Call;
import com.mariadesk.repositories.CallsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calls")
public class CallsController {

    private static final Logger LOG = LoggerFactory.getLogger(CallsController.class);

    private final CallsRepository callsRepository;

    @Autowired
    public CallsController(final CallsRepository callsRepository) {
        this.callsRepository = callsRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Call> getAll() {
        LOG.info("Getting all calls");
        return this.callsRepository.findAll();
    }

}
