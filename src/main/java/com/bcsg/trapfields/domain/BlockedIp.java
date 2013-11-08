package com.bcsg.trapfields.domain;

import javax.persistence.Column;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Represents an IP address that has been blocked.
 * @author alec
 *
 */
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class BlockedIp implements Timestamped {
	
	@Column(unique=true)
	private String ipAddress;
}
