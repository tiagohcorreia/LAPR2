package pt.ipp.isep.dei.esoft.project.domain.shared;

/**
 * The interface Multi story inhabitable property.
 */
public interface MultiStoryInhabitableProperty extends InhabitableProperty{
    /**
     * Gets has basement.
     *
     * @return the has basement
     */
    public boolean getHasBasement();

    /**
     * Gets has inhabitable loft.
     *
     * @return the has inhabitable loft
     */
    public boolean getHasInhabitableLoft();

    //private boolean setHasBasement(boolean hasBasement);
    //private boolean setHasInhabitableLoft(boolean hasInhabitableLoft);
}
