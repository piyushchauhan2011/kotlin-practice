/**
 * Created by piyushchauhan on 15/06/2016.
 */

import org.springframework.data.annotation.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class Customer(
    @Id @GeneratedValue(strategy= GenerationType.AUTO) val id: Long,
    val firstName: String,
    val lastName: String
)