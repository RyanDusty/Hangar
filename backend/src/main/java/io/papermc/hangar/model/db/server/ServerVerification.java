package io.papermc.hangar.model.db;

import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;
import java.sql.Timestamp;

public class ServerVerification extends Table {

    public static ServerVerification EMPTY = new ServerVerification(0, 0, 0, null, "null", null, null   );

    private long id;
    private long serverId;
    private long reviewerId;
    public Status status;
    private String notes;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    @JdbiConstructor
    public ServerVerification(long id, long serverId, long reviewerId, Status status, String notes, Timestamp createdAt, Timestamp updatedAt ) {
        this.id = id;
        this.serverId = serverId;
        this.reviewerId = reviewerId;
        this.status = status;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;


    }
    // GET METHODS
    public long getServerId() { return this.id; }
    public long getVerificationId() { return this.serverId; }
    public long getReviewerId() { return this.reviewerId; }
    public Status getVerificationStatus() { return this.status; }
    public String getServerNotes() { return this.notes; }
    public Timestamp getServerCreatedAt() { return this.createdAt; }
    public Timestamp getServerUpdatedAt() { return this.updatedAt; }
    // SET METHODS
    public void setVerificationId(long id) { this.id = id; }
    public void setServerId(long serverId) { this.serverId = serverId; }
    public void setReviewerId(long reviewerId) { this.reviewerId = reviewerId; }
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


