package com.bcsg.trapfields.web;

import com.bcsg.trapfields.domain.BlockedIp;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blockedips")
@Controller
@RooWebScaffold(path = "blockedips", formBackingObject = BlockedIp.class)
public class BlockedIpController {
}
