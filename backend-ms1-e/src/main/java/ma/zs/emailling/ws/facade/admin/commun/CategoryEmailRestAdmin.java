package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.dao.criteria.core.commun.CategoryEmailCriteria;
import ma.zs.emailling.service.facade.admin.commun.CategoryEmailAdminService;
import ma.zs.emailling.ws.converter.commun.CategoryEmailConverter;
import ma.zs.emailling.ws.dto.commun.CategoryEmailDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/categoryEmail/")
public class CategoryEmailRestAdmin  extends AbstractController<CategoryEmail, CategoryEmailDto, CategoryEmailCriteria, CategoryEmailAdminService, CategoryEmailConverter> {



    @Operation(summary = "upload one categoryEmail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categoryEmails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categoryEmails")
    @GetMapping("")
    public ResponseEntity<List<CategoryEmailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categoryEmails")
    @GetMapping("optimized")
    public ResponseEntity<List<CategoryEmailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categoryEmail by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CategoryEmailDto> findByName(@PathVariable String name) {
        return super.findByReferenceEntity(new CategoryEmail(name));
    }

    @Operation(summary = "Saves the specified  categoryEmail")
    @PostMapping("")
    public ResponseEntity<CategoryEmailDto> save(@RequestBody CategoryEmailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categoryEmail")
    @PutMapping("")
    public ResponseEntity<CategoryEmailDto> update(@RequestBody CategoryEmailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categoryEmail")
    @PostMapping("multiple")
    public ResponseEntity<List<CategoryEmailDto>> delete(@RequestBody List<CategoryEmailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categoryEmail")
    @DeleteMapping("")
    public ResponseEntity<CategoryEmailDto> delete(@RequestBody CategoryEmailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categoryEmail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categoryEmails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categoryEmail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategoryEmailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categoryEmails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategoryEmailDto>> findByCriteria(@RequestBody CategoryEmailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categoryEmails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategoryEmailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categoryEmails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategoryEmailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categoryEmail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategoryEmailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategoryEmailRestAdmin (CategoryEmailAdminService service, CategoryEmailConverter converter) {
        super(service, converter);
    }




}
