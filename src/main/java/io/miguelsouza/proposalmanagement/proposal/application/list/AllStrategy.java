package io.miguelsouza.proposalmanagement.proposal.application.list;

import io.miguelsouza.proposalmanagement.proposal.domain.OwnerId;
import io.miguelsouza.proposalmanagement.proposal.domain.Proposal;
import io.miguelsouza.proposalmanagement.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllStrategy implements Strategy {
    private final ProposalRepository proposalRepository;

    public AllStrategy(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public List<Proposal> getProposals(OwnerId ownerId) {
        return proposalRepository.findAll();
    }

    @Override
    public AccessScope getScope() {
        return AccessScope.ALL;
    }
}
