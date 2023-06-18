package pt.ipp.isep.dei.esoft.project.domain.dto;
import pt.ipp.isep.dei.esoft.project.domain.model.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.model.Client;
import pt.ipp.isep.dei.esoft.project.domain.model.Employee;
import pt.ipp.isep.dei.esoft.project.domain.model.Property;
import pt.ipp.isep.dei.esoft.project.domain.shared.TypeOfBusiness;
import pt.ipp.isep.dei.esoft.project.domain.shared.AnnouncementStatus;

import java.time.LocalDate;
public class AnnouncementRequestDTO {

        private LocalDate date;
        private AnnouncementStatus status;
        private float price;
        private TypeOfBusiness typeOfBusiness;
        private Property property;
        private Employee agent;
        private Client owner;




        public void AnnouncementRequestDTO(LocalDate date, AnnouncementStatus status, float price, TypeOfBusiness typeOfBusiness, Property property, Employee agent, Client owner) {
            this.date = LocalDate.now();
            this.status = status;
            this.price = price;
            this.typeOfBusiness = typeOfBusiness;
            this.property = property;
            this.agent = agent;
            this.owner = owner;
        }



        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public AnnouncementStatus getStatus() {
            return status;
        }

        public void setStatus(AnnouncementStatus status) {
            this.status = status;
        }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.status = status;
    }


    public TypeOfBusiness getTypeOfBusiness() {
            return typeOfBusiness;
        }

        public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
            this.typeOfBusiness = typeOfBusiness;
        }

        public Property getProperty() {
            return property;
        }

        public void setProperty(Property property) {
            this.property = property;
        }

    public Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
            this.agent = agent;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Announcement - Date: ").append(String.format("%-12s", date.toString()));
            sb.append("Status: ").append(String.format("%-10s", status));
            sb.append("Business Type: ").append(String.format("%-10s", typeOfBusiness));
            sb.append("Property: ").append(property.toString());
            sb.append("Owner: ").append(owner.toString());
            return sb.toString();
        }


}
