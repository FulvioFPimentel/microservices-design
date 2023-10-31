package br.com.fpimentel.clientapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fpimentel.clientapi.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
