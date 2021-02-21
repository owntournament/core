package org.owntournament.core.interfaces.models;

import java.time.Instant;

public interface IBaseDTO {
	Long getId();
	void setId(Long id);
	Long getVersion();
	void setVersion(Long version);
	Instant getCreatedAt();
	void setCreatedAt(Instant createdAt);
	Instant getUpdatedAt();
	void setUpdatedAt(Instant updatedAt);
}
