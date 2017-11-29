import java.util.Stack;

public class BrowserModel {

	public BrowserView view;
	public final static int HOME = 0;
	public Stack<Integer> forwardStack, backStack;
	public int currentLine;

	public BrowserModel(BrowserView view) {
		this.view = view;
	}

	public boolean hasBack() {
		return !backStack.empty();
	}

	public boolean hasForward() {
		return !forwardStack.empty();
	}

	public void home() {
		followLink(HOME);
		backStack.clear();

	}

	public void forward() {
		view.update(forwardStack.pop());

	}

	public void back() {
		forwardStack.push(currentLine);
		currentLine = backStack.pop();
		view.update(currentLine);

	}

	public void followLink(int n) {
		backStack.push(currentLine);
		forwardStack.clear();
		view.update(n);

	}

}
