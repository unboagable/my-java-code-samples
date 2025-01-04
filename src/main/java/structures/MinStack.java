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
			min = null;
		}else{
			min = this.top;
			minData = this.top.data;
			LinkedListNode n = this.top;
			while(n.next != null){
				n=n.next;
				if (n.data < minData){
					min=n;
					minData=n.data;
				}
			}
		}
		
	}
	
	@Override
	void push(int item){
		if (min == null){
			super.push(item);
			min=this.top;
			minData=this.top.data;
		}else{
			if (minData > item){
				super.push(item);
				min=this.top;
				minData=this.top.data;
			}
		}
	}
}
