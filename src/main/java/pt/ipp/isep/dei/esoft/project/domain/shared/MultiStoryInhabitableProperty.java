package pt.ipp.isep.dei.esoft.project.domain.shared;

public interface MultiStoryInhabitableProperty extends InhabitableProperty{
    public boolean getHasBasement();
    public boolean getHasInhabitableLoft();

    //private boolean setHasBasement(boolean hasBasement);
    //private boolean setHasInhabitableLoft(boolean hasInhabitableLoft);
}
