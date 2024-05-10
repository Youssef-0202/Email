package  ma.zs.emailling.ws.facade.admin.emailgroup;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailDetailGroupCriteria;
import ma.zs.emailling.service.facade.admin.emailgroup.EmailDetailGroupAdminService;
import ma.zs.emailling.ws.converter.emailgroup.EmailDetailGroupConverter;
import ma.zs.emailling.ws.dto.emailgroup.EmailDetailGroupDto;
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
@RequestMapping("/api/admin/emailDetailGroup/")
public class EmailDetailGroupRestAdmin  extends AbstractController<EmailDetailGroup, EmailDetailGroupDto, EmailDetailGroupCriteria, EmailDetailGroupAdminService, EmailDetailGroupConverter> {



    @Operation(summary = "upload one emailDetailGroup")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emailDetailGroups")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emailDetailGroups")
    @GetMapping("")
    public ResponseEntity<List<EmailDetailGroupDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  emailDetailGroup")
    @PostMapping("")
    public ResponseEntity<EmailDetailGroupDto> save(@RequestBody EmailDetailGroupDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  emailDetailGroup")
    @PutMapping("")
    public ResponseEntity<EmailDetailGroupDto> update(@RequestBody EmailDetailGroupDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of emailDetailGroup")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailDetailGroupDto>> delete(@RequestBody List<EmailDetailGroupDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified emailDetailGroup")
    @DeleteMapping("")
    public ResponseEntity<EmailDetailGroupDto> delete(@RequestBody EmailDetailGroupDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified emailDetailGroup")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emailDetailGroups by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by email id")
    @GetMapping("email/id/{id}")
    public List<EmailDetailGroupDto> findByEmailId(@PathVariable Long id){
        return findDtos(service.findByEmailId(id));
    }
    @Operation(summary = "delete by email id")
    @DeleteMapping("email/id/{id}")
    public int deleteByEmailId(@PathVariable Long id){
        return service.deleteByEmailId(id);
    }
    @Operation(summary = "find by destination id")
    @GetMapping("destination/id/{id}")
    public List<EmailDetailGroupDto> findByDestinationId(@PathVariable Long id){
        return findDtos(service.findByDestinationId(id));
    }
    @Operation(summary = "delete by destination id")
    @DeleteMapping("destination/id/{id}")
    public int deleteByDestinationId(@PathVariable Long id){
        return service.deleteByDestinationId(id);
    }

    @Operation(summary = "Finds a emailDetailGroup and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailDetailGroupDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds emailDetailGroups by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailDetailGroupDto>> findByCriteria(@RequestBody EmailDetailGroupCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emailDetailGroups by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailDetailGroupCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emailDetailGroups by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailDetailGroupCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets emailDetailGroup data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailDetailGroupCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EmailDetailGroupRestAdmin (EmailDetailGroupAdminService service, EmailDetailGroupConverter converter) {
        super(service, converter);
    }




}
