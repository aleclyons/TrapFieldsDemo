package com.bcsg.trapfields.domain;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Interface utilising AspectJ ITDs to allow us to easily make our entities
 * timestamped.
 * 
 * @author alec
 * 
 */
public interface Timestamped {

	public Calendar getCreationTimestamp();

	public void setCreationTimestamp(Calendar creationTimestamp);

	public Calendar getModificationTimestamp();

	public void setModificationTimestamp(Calendar modificationTimestamp);

	/**
	 * AspectJ MixIn for any class which implements the interface. Provides a
	 * default implementation using AspectJ. This is the style shown in
	 * Manning's AspectJ in Action (2nd edition) for providing a default
	 * implementation interface.
	 * 
	 * @author tgh
	 */
	static aspect Impl {

		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "created", nullable = false, updatable = false)
		private Calendar Timestamped.creationTimestamp = Calendar.getInstance();

		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "last_modified", nullable = false)
		private Calendar Timestamped.modificationTimestamp = Calendar
				.getInstance();

		public Calendar Timestamped.getCreationTimestamp() {
			return this.creationTimestamp;
		}

		public void Timestamped.setCreationTimestamp(Calendar creationTimestamp) {
			this.creationTimestamp = creationTimestamp;
		}

		public Calendar Timestamped.getModificationTimestamp() {
			return this.modificationTimestamp;
		}

		public void Timestamped.setModificationTimestamp(
				Calendar modificationTimestamp) {
			this.modificationTimestamp = modificationTimestamp;
		}

		@PrePersist
		@PreUpdate
		private void Timestamped.updateModificationTimestampDuringPrePersistAndPreUpdate() {
			this.modificationTimestamp = Calendar.getInstance();
		}

	}

}