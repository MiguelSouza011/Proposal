package io.miguelsouza.proposalmanagement.proposal.application.list;

import io.miguelsouza.proposalmanagement.proposal.domain.OwnerId;
import io.miguelsouza.proposalmanagement.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposals(OwnerId ownerId);

    AccessScope getScope();
}
