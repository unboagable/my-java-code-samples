package structures;

//P3.2
public class MinStack extends LocalStack{
	Node min;
	int minData;
	
	@Override
	Node pop(){
		Node toReturn=super.pop();
		if (toReturn == min){
			updateMin();
		}
		return toReturn;
	}

	private void updateMin() {
		if (this.top == null){
			min=null;
		}else{
			min=this.top;
			minData=this.top.getData();
			Node n = this.top;
			while(n.next != null){
				n=n.next;
				if (n.getData() < minData){
					min=n;
					minData=n.getData();
				}
			}
		}
		
	}
	
	@Override
	void push(int item){
		if (min == null){
			super.push(item);
			min=this.top;
			minData=this.top.getData();
		}else{
			if (minData > item){
				super.push(item);
				min=this.top;
				minData=this.top.getData();
			}
		}
	}

}
