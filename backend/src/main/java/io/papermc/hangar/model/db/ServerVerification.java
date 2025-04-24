package io.papermc.hangar.model.db;

import java.sql.Timestamp;
import java.util.UUID;

public class ServerVerification extends Table {

    public static ServerVerification EMPTY = new ServerVerification(null, null, null, null, "null", null, null   );

    private UUID id;
    private UUID serverId;
    private UUID reviewerId;
    public Status status;
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }


    public ServerVerification(UUID id, UUID serverId, UUID reviewerId, Status status, String notes, Timestamp createdAt, Timestamp updatedAt ) {
        this.id = id;
        this.serverId = serverId;
        this.reviewerId = reviewerId;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;


    }
    // GET METHODS
    public UUID getServerId() { return this.id; }
    public UUID getVerificationId() { return this.serverId; }
    public UUID getReviewerId() { return this.reviewerId; }
    public Status getVerificationStatus() { return this.status; }
    public String getServerNotes() { return this.notes; }
    public Timestamp getServerCreatedAt() { return this.createdAt; }
    public Timestamp getServerUpdatedAt() { return this.updatedAt; }
    // SET METHODS
    // Setters mirroring your getter naming convention
    public void setVerificationId(UUID id) { this.id = id; }
    public void setServerId(UUID serverId) { this.serverId = serverId; }
    public void setReviewerId(UUID reviewerId) { this.reviewerId = reviewerId; }
    public void setVerificationStatus(Status status) { this.status = status; }
    public void setServerNotes(String notes) { this.notes = notes; }
    public void setServerCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public void setServerUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "ProjectCompact{" +
            "id=" + this.id +
            ", serverId='" + this.serverId + '\'' +
            ", reviewerId=" + this.reviewerId +
            ", serverVerificationStatus=" + this.status +
            ", createdAt=" + this.createdAt +
            ", updatedAt=" + this.updatedAt +
            "} " + super.toString();
    }
}


