package structures;

import java.util.HashMap;
import java.util.Map;

//P3.3
public class StackOfPlates extends LocalStack{
	int maxElements=4;
	Map<Integer, LocalStack> toStack=new HashMap<Integer, LocalStack>();
	int currentStackIndex;
	LocalStack currentStack;
	int currentStackSize;
	
	@Override
	Node pop(){
		if (currentStack != null){ 
			if (currentStack.top != null){
				Node item=currentStack.top;
				currentStack.top=currentStack.top.getNext();
				currentStackSize--;
				return item;
			}else if (currentStackIndex != 0){
				currentStackIndex--;
				currentStack= toStack.get(currentStackIndex);
				Node item=currentStack.top;
				currentStack.top=currentStack.top.getNext();
				currentStackSize=maxElements-1;
				return item;
			}
		}
		return null;
	}
	
	@Override
	void push(int item){
		if (currentStack == null){
			currentStack=new LocalStack();
			currentStack.push(item);
			currentStackIndex=0;
			toStack.put(currentStackIndex, currentStack);
			currentStackSize=1;
		}else{
			currentStack.push(item);
			currentStackSize++;
			if (currentStackSize == maxElements){
				currentStackIndex++;
				//in case already made
				if (toStack.containsKey(currentStackIndex)){
					currentStack=toStack.get(currentStackIndex);
				}else{
					currentStack=new LocalStack();
					toStack.put(currentStackIndex, currentStack);
				}
				currentStackSize=0;
			}
		}
	}

}
