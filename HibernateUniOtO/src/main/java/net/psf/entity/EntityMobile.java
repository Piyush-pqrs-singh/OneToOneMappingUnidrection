package net.psf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="entity_mobile")
public class EntityMobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_mobile")
	private Long id;
	
	private String mobileName;
	
	private String imeiNo;
	
	public EntityMobile(String mobileName, String imeiNo) {
		super();
		this.mobileName = mobileName;
		this.imeiNo = imeiNo;
	}

}
