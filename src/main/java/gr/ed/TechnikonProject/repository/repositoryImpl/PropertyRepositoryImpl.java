package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyRepositoryImpl extends RepositoryImpl<Property> implements PropertyRepository{

    @Override
    public List<Property> readByPropertyIdE9(int propertyIdE9) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Property> readByVATNumber(Owner propertyVATOwner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updatePropertyAddress(int propertyIdE9, String propertyAddress) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updatePropertyConstructionYear(int propertyIdE9, Year propertyConstructionYear) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updatePropertyType(int propertyIdE9, PropertyType propertyType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}