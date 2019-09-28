package com.bridgelabz.fundooproject.service;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;

public interface LabelService {
	public void save(LabelDetails label, Long noteId, String token);

	public void delete(Long noteId, String token);
}
