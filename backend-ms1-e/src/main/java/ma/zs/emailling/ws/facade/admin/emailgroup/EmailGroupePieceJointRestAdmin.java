package  ma.zs.emailling.ws.facade.admin.emailgroup;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.dao.criteria.core.emailgroup.EmailGroupePieceJointCriteria;
import ma.zs.emailling.service.facade.admin.emailgroup.EmailGroupePieceJointAdminService;
import ma.zs.emailling.ws.converter.emailgroup.EmailGroupePieceJointConverter;
import ma.zs.emailling.ws.dto.emailgroup.EmailGroupePieceJointDto;
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
@RequestMapping("/api/admin/emailGroupePieceJoint/")
public class EmailGroupePieceJointRestAdmin  extends AbstractController<EmailGroupePieceJoint, EmailGroupePieceJointDto, EmailGroupePieceJointCriteria, EmailGroupePieceJointAdminService, EmailGroupePieceJointConverter> {



    @Operation(summary = "upload one emailGroupePieceJoint")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple emailGroupePieceJoints")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all emailGroupePieceJoints")
    @GetMapping("")
    public ResponseEntity<List<EmailGroupePieceJointDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  emailGroupePieceJoint")
    @PostMapping("")
    public ResponseEntity<EmailGroupePieceJointDto> save(@RequestBody EmailGroupePieceJointDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  emailGroupePieceJoint")
    @PutMapping("")
    public ResponseEntity<EmailGroupePieceJointDto> update(@RequestBody EmailGroupePieceJointDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of emailGroupePieceJoint")
    @PostMapping("multiple")
    public ResponseEntity<List<EmailGroupePieceJointDto>> delete(@RequestBody List<EmailGroupePieceJointDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified emailGroupePieceJoint")
    @DeleteMapping("")
    public ResponseEntity<EmailGroupePieceJointDto> delete(@RequestBody EmailGroupePieceJointDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified emailGroupePieceJoint")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple emailGroupePieceJoints by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typecontenu id")
    @GetMapping("typecontenu/id/{id}")
    public List<EmailGroupePieceJointDto> findByTypecontenuId(@PathVariable Long id){
        return findDtos(service.findByTypecontenuId(id));
    }
    @Operation(summary = "delete by typecontenu id")
    @DeleteMapping("typecontenu/id/{id}")
    public int deleteByTypecontenuId(@PathVariable Long id){
        return service.deleteByTypecontenuId(id);
    }
    @Operation(summary = "find by groupeEmail id")
    @GetMapping("groupeEmail/id/{id}")
    public List<EmailGroupePieceJointDto> findByGroupeEmailId(@PathVariable Long id){
        return findDtos(service.findByGroupeEmailId(id));
    }
    @Operation(summary = "delete by groupeEmail id")
    @DeleteMapping("groupeEmail/id/{id}")
    public int deleteByGroupeEmailId(@PathVariable Long id){
        return service.deleteByGroupeEmailId(id);
    }

    @Operation(summary = "Finds a emailGroupePieceJoint and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmailGroupePieceJointDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds emailGroupePieceJoints by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmailGroupePieceJointDto>> findByCriteria(@RequestBody EmailGroupePieceJointCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated emailGroupePieceJoints by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmailGroupePieceJointCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports emailGroupePieceJoints by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmailGroupePieceJointCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets emailGroupePieceJoint data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmailGroupePieceJointCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EmailGroupePieceJointRestAdmin (EmailGroupePieceJointAdminService service, EmailGroupePieceJointConverter converter) {
        super(service, converter);
    }




}
