package guru.springfamework.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class CategoryDTO {
    @ApiModelProperty(value = "the id of category")
    private Long id;
    @ApiModelProperty(value = "the name of a category")
    private String name;
}
