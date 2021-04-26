package ch3.ch4_conditional;

public class WindowsListService implements ListService{
    @Override
    public String showListCmd() {
        return "dir";
    }
}
