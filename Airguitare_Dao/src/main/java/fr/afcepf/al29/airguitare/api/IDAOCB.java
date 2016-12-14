package fr.afcepf.al29.airguitare.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al29.airguitare.entities.CB;

@Local
public interface IDAOCB {

	List<CB> getCBByClient(int idClient);
}
