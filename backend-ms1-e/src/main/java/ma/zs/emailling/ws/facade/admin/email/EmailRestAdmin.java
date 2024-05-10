package  ma.zs.emailling.ws.facade.admin.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.dao.criteria.core.email.EmailCriteria;
import ma.zs.emailling.service.facade.admin.email.EmailAdminService;
import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.dto.email.EmailDto;
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
@RequestMapping("/api/admin/email/")
public class EmailRestAdmin  extends AbstractController<Email, EmailDto, EmailCriteria, EmailAdminService, EmailConverter> {



    @Operation(summary = "upload one email")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emails")
    @GetMapping("")
    public ResponseEntity<List<EmailDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all emails")
    @GetMapping("optimized")
    public ResponseEntity<List<EmailDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a email by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<EmailDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Email(ref));
    }

    @Operation(summary = "Saves the specified  email")
    @PostMapping("")
    public ResponseEntity<EmailDto> save(@RequestBody EmailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  email")
    @PutMapping("")
    public ResponseEntity<EmailDto> update(@RequestBody EmailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of email")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailDto>> delete(@RequestBody List<EmailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified email")
    @DeleteMapping("")
    public ResponseEntity<EmailDto> delete(@RequestBody EmailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified email")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by personneSource id")
    @GetMapping("personneSource/id/{id}")
    public List<EmailDto> findByPersonneSourceId(@PathVariable Long id){
        return findDtos(service.findByPersonneSourceId(id));
    }
    @Operation(summary = "delete by personneSource id")
    @DeleteMapping("personneSource/id/{id}")
    public int deleteByPersonneSourceId(@PathVariable Long id){
        return service.deleteByPersonneSourceId(id);
    }
    @Operation(summary = "find by categoryEmail id")
    @GetMapping("categoryEmail/id/{id}")
    public List<EmailDto> findByCategoryEmailId(@PathVariable Long id){
        return findDtos(service.findByCategoryEmailId(id));
    }
    @Operation(summary = "delete by categoryEmail id")
    @DeleteMapping("categoryEmail/id/{id}")
    public int deleteByCategoryEmailId(@PathVariable Long id){
        return service.deleteByCategoryEmailId(id);
    }
    @Operation(summary = "find by etatEmail id")
    @GetMapping("etatEmail/id/{id}")
    public List<EmailDto> findByEtatEmailId(@PathVariable Long id){
        return findDtos(service.findByEtatEmailId(id));
    }
    @Operation(summary = "delete by etatEmail id")
    @DeleteMapping("etatEmail/id/{id}")
    public int deleteByEtatEmailId(@PathVariable Long id){
        return service.deleteByEtatEmailId(id);
    }

    @Operation(summary = "Finds a email and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds emails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailDto>> findByCriteria(@RequestBody EmailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets email data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @PostMapping("sendEmail")
    public Email sendEmail(@RequestBody Email email) {
        return service.sendEmail(email);
    }

    public EmailRestAdmin (EmailAdminService service, EmailConverter converter) {
        super(service, converter);
    }




}
