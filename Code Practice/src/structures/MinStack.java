package structures;

//P3.2
public class MinStack extends LocalStack{
	LinkedListNode min;
	int minData;
	
	@Override
	LinkedListNode pop(){
		LinkedListNode toReturn=super.pop();
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
			LinkedListNode n = this.top;
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
