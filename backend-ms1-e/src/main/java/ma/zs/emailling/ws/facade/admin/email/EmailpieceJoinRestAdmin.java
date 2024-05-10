package  ma.zs.emailling.ws.facade.admin.email;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.dao.criteria.core.email.EmailpieceJoinCriteria;
import ma.zs.emailling.service.facade.admin.email.EmailpieceJoinAdminService;
import ma.zs.emailling.ws.converter.email.EmailpieceJoinConverter;
import ma.zs.emailling.ws.dto.email.EmailpieceJoinDto;
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
@RequestMapping("/api/admin/emailpieceJoin/")
public class EmailpieceJoinRestAdmin  extends AbstractController<EmailpieceJoin, EmailpieceJoinDto, EmailpieceJoinCriteria, EmailpieceJoinAdminService, EmailpieceJoinConverter> {



    @Operation(summary = "upload one emailpieceJoin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emailpieceJoins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emailpieceJoins")
    @GetMapping("")
    public ResponseEntity<List<EmailpieceJoinDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  emailpieceJoin")
    @PostMapping("")
    public ResponseEntity<EmailpieceJoinDto> save(@RequestBody EmailpieceJoinDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  emailpieceJoin")
    @PutMapping("")
    public ResponseEntity<EmailpieceJoinDto> update(@RequestBody EmailpieceJoinDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of emailpieceJoin")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailpieceJoinDto>> delete(@RequestBody List<EmailpieceJoinDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified emailpieceJoin")
    @DeleteMapping("")
    public ResponseEntity<EmailpieceJoinDto> delete(@RequestBody EmailpieceJoinDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified emailpieceJoin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emailpieceJoins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by email id")
    @GetMapping("email/id/{id}")
    public List<EmailpieceJoinDto> findByEmailId(@PathVariable Long id){
        return findDtos(service.findByEmailId(id));
    }
    @Operation(summary = "delete by email id")
    @DeleteMapping("email/id/{id}")
    public int deleteByEmailId(@PathVariable Long id){
        return service.deleteByEmailId(id);
    }
    @Operation(summary = "find by typeContenu id")
    @GetMapping("typeContenu/id/{id}")
    public List<EmailpieceJoinDto> findByTypeContenuId(@PathVariable Long id){
        return findDtos(service.findByTypeContenuId(id));
    }
    @Operation(summary = "delete by typeContenu id")
    @DeleteMapping("typeContenu/id/{id}")
    public int deleteByTypeContenuId(@PathVariable Long id){
        return service.deleteByTypeContenuId(id);
    }

    @Operation(summary = "Finds a emailpieceJoin and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailpieceJoinDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds emailpieceJoins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailpieceJoinDto>> findByCriteria(@RequestBody EmailpieceJoinCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emailpieceJoins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailpieceJoinCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emailpieceJoins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailpieceJoinCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets emailpieceJoin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailpieceJoinCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EmailpieceJoinRestAdmin (EmailpieceJoinAdminService service, EmailpieceJoinConverter converter) {
        super(service, converter);
    }




}
