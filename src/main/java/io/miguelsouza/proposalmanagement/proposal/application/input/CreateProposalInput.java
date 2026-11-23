package io.miguelsouza.proposalmanagement.proposal.application.input;

import io.miguelsouza.proposalmanagement.proposal.domain.Owner;
import io.miguelsouza.proposalmanagement.proposal.domain.Proposal;

import java.util.Optional;

public record CreateProposalInput(String title, Optional<String> description) {
    public Proposal toDomain(Owner owner) {
        return new Proposal(title, description, owner);
    }
}
