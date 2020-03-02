package devutility.internal.test.model;

import java.util.LinkedList;
import java.util.List;

public class NormalModel {
	private String name;
	private ReferencedModel referencedModel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReferencedModel getReferencedModel() {
		return referencedModel;
	}

	public void setReferencedModel(ReferencedModel referencedModel) {
		this.referencedModel = referencedModel;
	}

	public static List<NormalModel> list(int count) {
		List<NormalModel> list = new LinkedList<>();

		for (int i = 0; i < count; i++) {
			NormalModel model = new NormalModel();
			model.setName(String.format("name_%d", i));

			ReferencedModel referencedModel = new ReferencedModel();
			referencedModel.setName(String.format("referenced_name_%d", i));
			model.setReferencedModel(referencedModel);
			list.add(model);
		}

		return list;
	}
}