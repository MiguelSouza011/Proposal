package io.miguelsouza.proposalmanagement.proposal.application;

import io.miguelsouza.proposalmanagement.proposal.application.input.CreateProposalInput;
import io.miguelsouza.proposalmanagement.proposal.application.output.ProposalOutput;
import io.miguelsouza.proposalmanagement.proposal.domain.Owner;
import io.miguelsouza.proposalmanagement.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public ProposalOutput execute(CreateProposalInput input, Owner owner) {
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);

        return ProposalOutput.from(saved);
    }
}
