package  ma.zs.emailling.ws.facade.admin.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.dao.criteria.core.email.EmailDetailCriteria;
import ma.zs.emailling.service.facade.admin.email.EmailDetailAdminService;
import ma.zs.emailling.ws.converter.email.EmailDetailConverter;
import ma.zs.emailling.ws.dto.email.EmailDetailDto;
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
@RequestMapping("/api/admin/emailDetail/")
public class EmailDetailRestAdmin  extends AbstractController<EmailDetail, EmailDetailDto, EmailDetailCriteria, EmailDetailAdminService, EmailDetailConverter> {



    @Operation(summary = "upload one emailDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emailDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emailDetails")
    @GetMapping("")
    public ResponseEntity<List<EmailDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  emailDetail")
    @PostMapping("")
    public ResponseEntity<EmailDetailDto> save(@RequestBody EmailDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  emailDetail")
    @PutMapping("")
    public ResponseEntity<EmailDetailDto> update(@RequestBody EmailDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of emailDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailDetailDto>> delete(@RequestBody List<EmailDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified emailDetail")
    @DeleteMapping("")
    public ResponseEntity<EmailDetailDto> delete(@RequestBody EmailDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified emailDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emailDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by email id")
    @GetMapping("email/id/{id}")
    public List<EmailDetailDto> findByEmailId(@PathVariable Long id){
        return findDtos(service.findByEmailId(id));
    }
    @Operation(summary = "delete by email id")
    @DeleteMapping("email/id/{id}")
    public int deleteByEmailId(@PathVariable Long id){
        return service.deleteByEmailId(id);
    }
    @Operation(summary = "find by personneDestinataire id")
    @GetMapping("personneDestinataire/id/{id}")
    public List<EmailDetailDto> findByPersonneDestinataireId(@PathVariable Long id){
        return findDtos(service.findByPersonneDestinataireId(id));
    }
    @Operation(summary = "delete by personneDestinataire id")
    @DeleteMapping("personneDestinataire/id/{id}")
    public int deleteByPersonneDestinataireId(@PathVariable Long id){
        return service.deleteByPersonneDestinataireId(id);
    }
    @Operation(summary = "find by etatEmail id")
    @GetMapping("etatEmail/id/{id}")
    public List<EmailDetailDto> findByEtatEmailId(@PathVariable Long id){
        return findDtos(service.findByEtatEmailId(id));
    }
    @Operation(summary = "delete by etatEmail id")
    @DeleteMapping("etatEmail/id/{id}")
    public int deleteByEtatEmailId(@PathVariable Long id){
        return service.deleteByEtatEmailId(id);
    }

    @Operation(summary = "Finds a emailDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds emailDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailDetailDto>> findByCriteria(@RequestBody EmailDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emailDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emailDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets emailDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EmailDetailRestAdmin (EmailDetailAdminService service, EmailDetailConverter converter) {
        super(service, converter);
    }




}
