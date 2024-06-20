package structures.family_tree;

public final class FamilyDemograpgic {
	int type = 0; //0 = orphan, 1 = single family, 2 = full family
	
	public FamilyDemograpgic(int dem){
		if(dem % 2 >= 2) {
			type = -1;
		}
		type = dem;
	}
}
