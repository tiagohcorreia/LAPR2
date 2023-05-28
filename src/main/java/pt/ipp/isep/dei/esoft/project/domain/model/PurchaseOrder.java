//package pt.ipp.isep.dei.esoft.project.domain.model;
//
//import pt.ipp.isep.dei.esoft.project.domain.dto.AnnouncementDTO;
//
//public class PurchaseOrder extends Order {
//    private String id;
//    private AnnouncementDTO announcementDTO;
//    private boolean accepted;
//
//    public PurchaseOrder(String id, double orderAmount, AnnouncementDTO announcementDTO) {
//        super(id, orderAmount, announcementDTO);
//        this.announcementDTO = announcementDTO;
//        this.accepted = false;
//    }
//
//    public AnnouncementDTO getAnnouncementDTO() {
//        return announcementDTO;
//    }
//
//    public AnnouncementDTO setAnnouncementDTO(AnnouncementDTO announcementDTO) {
//        this.announcementDTO = announcementDTO;
//        return announcementDTO;
//    }
//
//    public boolean isAccepted() {
//        return accepted;
//    }
//
//    public void setAccepted(boolean accepted) {
//        this.accepted = accepted;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("PurchaseOrder{");
//        sb.append("id=").append(getId());
//        sb.append("orderAmount=").append(getOrderAmount());
//        sb.append(", announcementDTO=").append(announcementDTO);
//        sb.append(", status=").append(isStatus());
//        sb.append('}');
//        return sb.toString();
//    }
//}
