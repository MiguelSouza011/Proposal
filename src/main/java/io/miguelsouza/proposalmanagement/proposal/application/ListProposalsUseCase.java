package io.miguelsouza.proposalmanagement.proposal.application;

import io.miguelsouza.proposalmanagement.proposal.application.list.AccessScope;
import io.miguelsouza.proposalmanagement.proposal.application.list.Factory;
import io.miguelsouza.proposalmanagement.proposal.application.output.ProposalOutput;
import io.miguelsouza.proposalmanagement.proposal.domain.OwnerId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProposalsUseCase {
    private final Factory factory;

    public ListProposalsUseCase(Factory factory) {
        this.factory = factory;
    }

    public List<ProposalOutput> execute(AccessScope scope, OwnerId ownerId) {
        var proposals = factory.getStrategy(scope).getProposals(ownerId);

        return proposals.stream().map(ProposalOutput::from).toList();
    }
}
