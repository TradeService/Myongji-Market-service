package com.example.myongjimarket.domain.TalentDonationPost.dto;

        import com.example.myongjimarket.domain.TalentDonationPost.TalentDonationPost;
        import lombok.Getter;
        import lombok.Setter;
        import org.springframework.stereotype.Component;

        import java.time.LocalDateTime;
        import java.util.List;
        import java.util.stream.Collectors;

@Getter
@Setter
@Component
public class TalentDonationPostDto {
    private Long id;
    private String title;
    private String content;
    private String topic;
    private byte[] picture;
    private String place;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String person;
    private String plan;

    public TalentDonationPostDto() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public TalentDonationPostDto(Long id, String title, String content, String topic, byte[] picture, String place, LocalDateTime created_at, LocalDateTime updated_at, String person, String plan) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.picture = picture;
        this.place = place;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.person = person;
        this.plan = plan;
    }

    public List<TalentDonationPostDto> convertToDtoList(List<TalentDonationPost> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<TalentDonationPost> convertToEntityList(List<TalentDonationPostDto> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public TalentDonationPostDto convertToDto(TalentDonationPost entity) {
        return new TalentDonationPostDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getTopic(),
                entity.getPicture(),
                entity.getPlace(),
                entity.getCreated_at(),
                entity.getUpdated_at(),
                entity.getPerson(),
                entity.getPlan()
        );
    }

    public TalentDonationPost convertToEntity(TalentDonationPostDto dto) {
        return new TalentDonationPost(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                dto.getTopic(),
                dto.getPicture(),
                dto.getPlace(),
                dto.getCreated_at(),
                dto.getUpdated_at(),
                dto.getPerson(),
                dto.getPlan(),
                null
        );
    }
}
