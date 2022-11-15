package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.model.Property;

public interface PropertyRepository extends Repository<Property> {
    void updateAll(int propertyId, Property newProperty);
}
