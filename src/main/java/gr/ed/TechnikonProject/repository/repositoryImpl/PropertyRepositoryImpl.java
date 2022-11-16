package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyRepositoryImpl extends RepositoryImpl<Property> implements PropertyRepository{

    @Override
    public void updateAll(int propertyId, Property newProperty) {
        Property property = read(propertyId);
        if (property != null) {
            property.setPropertyE9(newProperty.getPropertyE9());
            property.setPropertyAddress(newProperty.getPropertyAddress());
            property.setPropertyConstructionYear(newProperty.getPropertyConstructionYear());
            property.setPropertyType(newProperty.getPropertyType());
            property.setPropertyVATOwner(newProperty.getPropertyVATOwner());
        }
    }

    @Override
    public List<Property> searchByPropertyId(int propertyE9) {
        return read()
                .stream()
                .filter(property->property.getPropertyE9() == propertyE9)
                .collect(Collectors.toList());
               
    }

    @Override
    public List<Property> searchByVATNumber(String propertyVATOwner) {
        return read()
                .stream()
                .filter(property->property.getPropertyVATOwner().equals(propertyVATOwner))
                .collect(Collectors.toList());
    }

}
